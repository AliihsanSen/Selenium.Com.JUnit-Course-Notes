package Day12_ReadExcel;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        // Amazon sayfasına gidelim tüm sayfanın resmini alalım.
        driver.get("https://amazon.com");

        Faker faker = new Faker();
        TakesScreenshot ts = (TakesScreenshot) driver;
        /*
        ==> Bir web sayfanın resmini alabilmek için TakesScreenshot class2ından obje oluşturup
        gecici bir file class'ından değişkene TakesScreenShot'dan oluşturduğum objeden
        getScteenshotsAs methodunu kullanarak geçici bir file methodu oluştururuz.
         */

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formatter);
        System.out.println(date);
        System.out.println(tarih);


        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/AllPage" + tarih + ".jpeg"));

    }
}
