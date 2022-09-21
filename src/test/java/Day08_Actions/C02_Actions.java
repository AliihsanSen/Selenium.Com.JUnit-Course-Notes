package Day08_Actions;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C02_Actions extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // 1- https://www.facebook.com adresine gidelim.
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim.
        WebElement account = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        account.click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim.
        WebElement name = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        actions.click(name).sendKeys("Ali").sendKeys(Keys.TAB).sendKeys("Şen").
                sendKeys(Keys.TAB).sendKeys("ornek@gmail.com").sendKeys(Keys.TAB).
                sendKeys("ornek@gmail.com").sendKeys(Keys.TAB).sendKeys("147856").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("5").sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1997").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();

        // 4- Kaydol tusuna basalim.

    }
}
