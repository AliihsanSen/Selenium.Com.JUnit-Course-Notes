package Day12_ReadExcel;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        // Amazon sayfasına gidelim tüm sayfanın resmini alalım.
        driver.get("https://amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        /*
        ==> Bir web sayfanın resmini alabilmek için TakesScreenshot class2ından obje oluşturup
        gecici bir file class'ından değişkene TakesScreenShot'dan oluşturduğum objeden
        getScteenshotsAs methodunu kullanarak geçici bir file methodu oluştururuz.
         */
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage.jpeg"));

    }
}
