package Day10_Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // login( ) metodun oluşturun ve oturum açın.
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        // Username : manager
        // Password : Manager1!
        login();

        // table( ) metodu oluşturun
        table();
    }

    public void login() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//*[@id='UserName']")).
                sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    public void table() {

        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
        Tabloda <table> tag'ı altında tablonun başlığını gösteren <thead> tagı bulunur.
        Eğer başlık satır (row) varsa <thead> tag'ı altında <tr> (satır-row) tagı vardır.
        Ve başlıktaki sütunlara yani hücrelere (cell) de <th> tag'ı ile ulaşılır.
        Başlığın altındaki tablodaki verilere <tbody> tag'ı ile altındaki satirlara(row)
        <tr> tag'ı ile sütunlara yani hücrelere <td> tag'ı ile ulaşırız.
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : " + sutunSayisi.size());

        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());

        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body : " + body.getText());

        // printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satır sayisi : " + satirList.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.stream().forEach(t -> System.out.println(t.getText()));

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.satir "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }
}
