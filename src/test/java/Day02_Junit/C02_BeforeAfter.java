package Day02_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;

    @Before
    // Before rotasyonu her testen once çalışır.
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    // Testimizi run ettiğimiz kısım.
    public void method1(){

        // 1 defa before methodu çalışır.
        driver.get("https://amazon.com");
        // 1 defa da after methodu çalışır.
    }

    @Test
    public void method2(){

        driver.get("https://trendyol.com");
    }

    @Test
    public void method3(){

        driver.get("https://hepsiburada.com");
    }


    @After
    // After rotasyonu her testten sonra çalışır.
    public void tearDown(){

        driver.quit();
    }

    /*
    bir class da;
     -->@before ile olusturulan method class icindeki her test method'undan once ve 1 kez calisir ve
     genellikle public  void setup() seklinde yazilir

     -->@after ile olusturlan method class icindeki her test method'undan sonra ve 1 kez calisir ve
     genellikle public void tearDown() seklinde yazilir
     */

}
