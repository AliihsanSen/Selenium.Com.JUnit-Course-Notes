package Day10_Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // Bir önceki class'daki adrse gidelim.
        // Login() methodunu kullanarak sayfaya giriş yapalım.
        login();

        int satir = 3;
        int sutun = 4;
        // İnput olarak verilen satır sayısı ve sutun sayısına sahip cell'daki text'i yazdıralim
        WebElement cell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println("Satır ve sutundaki text : " + cell.getText());

        // PhoneNo başlığındaki tüm numaraları yazdırın.
        List<WebElement> PhoneNo=driver.findElements(By.xpath("//tbody//tr[*]//td[6]"));
        PhoneNo.forEach(t-> System.out.println(t.getText()));

        /*
        Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
        Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
        Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
        Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
        sutunlara yani hucrelere<td> tag'i ile ulasilir.
         */
    }

    public void login() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//*[@id='UserName']")).
                sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

    }
}
