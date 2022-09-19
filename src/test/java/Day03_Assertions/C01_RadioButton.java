package Day03_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method() throws InterruptedException {
        // 3-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // 4-Cookies'i kabul edin
        // 5-"Create an Account" button'una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // 6-"radio buttons" elementlerini locate edin
        WebElement radioButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

        // 7-Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(1500);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
