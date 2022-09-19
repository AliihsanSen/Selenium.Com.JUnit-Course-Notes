package Day03_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

    /*
     Not :
     ==> BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
     BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.

     ==> BeforeAfter methodunda methodların static yapmaya gerek yok ama
     BeforeAfterCLass'da static yapmak zorunlu.
     */

    /*
    Parametre olarak iki değer alır.
    İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
    assertFalse
    beklenen bir sonucun false olması durumunda kullanılır.
    İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
    assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.
     */


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    // 3 farklı test methodu oluşturalım
    @Test
    public void test1() {
        //    a-) Url'nin amazon içerdiğini test edelim.
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void test2() {
        //    b-) Tittle'in facebook içermediğini test edelim.
        String expectedTitle = "facebok";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test3() {
        //    c-) sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
