package Day02_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    /*
    BeforeClass ve AfterClass rotasyonları kullanıyorsak oluşturacağımız method'u
    static yapmamız gerekiyor.
     */

    /*
    ==> BeforeClass - AfterClass ---> BeforeClass+Test+Test+Test+AfterClass
        çalışıyor sırayla (toplam 5 method çalışıyor)
    ==> Tüm testleri aynı browser'da açtı, son testten sonra browser'ı kapattı
    ==> Before - After ---> Before+Test+After
    Before+Test+After   Before+Test+After şeklinde (toplam 9 method çalışıyor)
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }

    @Test
    @Ignore ("String açıklamada yazılabilir.")
    /*
    Çalışmasını istemediğimiz test için @Ignore rotasyonu kullanılır.
     */
    public void method1() {

        driver.get("https://amazon.com");
    }

    @Test
    public void method2() {

        driver.get("https://trendyol.com");
    }

    @Test
    public void method3() {

        driver.get("https://hepsiburada.com");
    }
}
