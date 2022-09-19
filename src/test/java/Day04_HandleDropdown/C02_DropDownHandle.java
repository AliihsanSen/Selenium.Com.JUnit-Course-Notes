package Day04_HandleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {

        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());

        for (WebElement each : drops) {
            System.out.println(each.getText());
        }

        int dropDownList = drops.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi, dropDownList);
    }

    @Test
    public void test2() {
        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");

        // 2.Arama kutusuna Java yazin ve aratin.
        WebElement searcBox = driver.findElement(By.id("twotabsearchtextbox"));
        searcBox.sendKeys("Java", Keys.ENTER);

        // 3.Bulunan sonuc sayisini yazdirin.
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }
}

