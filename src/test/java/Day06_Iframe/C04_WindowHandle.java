package Day06_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowHandle {

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
    public void test(){

        //  Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //  Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //  Sayfa title’nin “Amazon” icerdigini test edin
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));

        //  Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //  Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = driver.getTitle();
        Assert.assertTrue(walmartTitle.contains("Walmart"));

        //  Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());

    }
}
