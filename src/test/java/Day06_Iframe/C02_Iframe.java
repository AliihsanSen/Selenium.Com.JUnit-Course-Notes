package Day06_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Iframe {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
       driver.quit();
    }


    @Test
    public void test18() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeText.isEnabled());
        System.out.println("iframeText.getText() = " + iframeText.getText());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr")); // Frame'e geçiş yapmadan önce orayı id ile locate ederiz
        driver.switchTo().frame(textBox); // Locate ettiğimiz frame geçmek için bu methodu kullanırız
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear(); // Clear methodu text box'ın içini temizler
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dunya!");
        driver.switchTo().defaultContent(); // ==> Frame'den çıkmak için mutlaka yazmamız gerekiyor. Yoksa kodlarımızda hata alırız.

        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //  dogrulayin ve konsolda yazdirin
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println("elemental.getText() = " + elemental.getText());

    }
}
