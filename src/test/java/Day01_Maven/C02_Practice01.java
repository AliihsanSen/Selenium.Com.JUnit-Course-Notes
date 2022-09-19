package Day01_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Practice01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna 10 kez basinız
        WebElement addElementButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        int sayac = 0;

        for (int i = 0; i < 10; i++) {
            addElementButton.click();
            sayac++;
        }

        // 3- 10 kez Add element butonuna basıldığını test ediniz
        if (sayac == 10) {
            System.out.println("Butona " + sayac + "  kez basılmıştır test PASSED");
        } else {
            System.out.println("Butona basılma testi FAILAD");
        }

        // 4 - Delete butonuna görünmeyene kadar basınız
        List<WebElement> deleteButon = driver.findElements(By.xpath("//*[@class='added-manually']"));
        int basmaSayisi = 10;

        for (int i = 0; i < 10; i++) {
            deleteButon.get(i).click();
            basmaSayisi--;
        }

        // 5- Delete butonunun görünmediğini test ediniz
        if (basmaSayisi == 0) {
            System.out.println("Delete butonuna 10 kez basıldığından Button görünmüyor test PASSED");
        } else {
            System.out.println("Delete butonuna 10 kez basılmadığından test FAILED");
        }

        // 6- Sayfayı kapatınız
        driver.quit();
    }
}
