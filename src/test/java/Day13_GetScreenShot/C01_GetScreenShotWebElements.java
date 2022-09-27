package Day13_GetScreenShot;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_GetScreenShotWebElements extends TestBaseBeforeAfter {

    @Test
    public void name() throws IOException {

        // Amazon sayfasına gidelim.
        driver.get("https://amazon.com");

        // Nutella aratalım.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);

        // Arama sonucunun resmini alalım.
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusuWE/WebElementSS.jpeg"));

        /*
        Ve sonuç sayısının olduğu, web elementin fotoğrafını ekleyelim.Belirli bölgelerin
        ekran görüntüsünü almak istersek o bölgeyi locate etmek gerekir.
        Aynı zamanda belirli bölgeyi çekmek istediğimizde alttaki objeyi oluşturmaya
        gerek yok ! Arasındaki tek fark bu !
        TakesScreenshot ts= (TakesScreenshot) driver;
         */


    }
}
