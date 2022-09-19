package Day06_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {

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
    public void test() {

        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("amazon"));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencere açmak için bu methodu kullanırız
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();

        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Best Buy"));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle); // Sayfalar arası geçiş için bu method kullanılır
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içermediğini test edelim
        WebElement resultTextWE=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult=resultTextWE.getText();
        Assert.assertFalse(actualResult.contains("java"));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        /*
        Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get()
        methodundan sonra driver'ın window handle değerini string bir değişkene atarız
        Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya
        dönmemiz istenirseString değişkene atadığımız window handle değerleriyle
        sayfalar arası geçiş yapabiliriz
         */
    }
}
