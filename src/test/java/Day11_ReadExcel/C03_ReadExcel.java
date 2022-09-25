package Day11_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void name() throws IOException {

        // Belirtilen satırNo ve sütunNo değerlerini parametre olarak alıp o cell'deki
        // datayı konsala yazdıralım.

        // Sonucun konsolda aynı olduğunu doğrulayın.

        int satir = 12;
        int sutun = 2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actuladData = workbook.
                getSheet("Sayfa1").
                getRow(satir - 1).
                getCell(sutun - 1).toString();
        System.out.println(actuladData);

        String expectedData = "Baku";
        Assert.assertEquals(actuladData, expectedData);

        /*
         İndex 0'dan başladığı için bizden istenen satıra ulaşabilmek için bir
         eksiğini alır.
         */

    }
}
