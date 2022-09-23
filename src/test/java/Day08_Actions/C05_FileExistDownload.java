package Day08_Actions;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistDownload extends TestBaseBeforeAfter {

    @Test
    public void name() {

        //  https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //  test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();

        //  Ardından isExist( ) methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\USER\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // İndirildiğini konsolda gösterin.
        System.out.println(Files.exists(Paths.get(dosyaYolu))); // true
    }
}
