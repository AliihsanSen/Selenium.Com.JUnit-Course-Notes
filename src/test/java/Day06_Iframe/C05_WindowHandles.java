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
import java.util.ArrayList;
import java.util.List;

public class C05_WindowHandles {

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
    public void method() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        String expectedUser = "Opening a new window";
        String actualUser = text.getText();
        Assert.assertEquals(expectedUser, actualUser);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        /*
        Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme
        ya da pencere acilirsa buyeni acilan sekmenin handle degerini bulabilmek
        icin driver.getWindowHandles() methodunu bir ArrayList'e atip butun sayfalarin
        listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan
        sekmenin index'i 1'dir ve ikinci acilan pencere veya sekmede islem
        yapabilmek icin driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
         */


        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(windowList.get(1));
        String actualTitle2 = driver.getTitle();
        Assert.assertTrue(actualTitle2.contains("New Window"));

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement text2 = driver.findElement(By.xpath("//h3"));
        String actualUser2 = text2.getText();
        Assert.assertTrue(actualUser2.contains("New Window"));

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        String head = driver.getTitle();
        Assert.assertTrue(head.contains("The Internet"));
    }
}
