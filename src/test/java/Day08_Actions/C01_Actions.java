package Day08_Actions;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void name() {

        //  https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //  Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(textBox).
                sendKeys("s").sendKeys("a").sendKeys("m").sendKeys("s").sendKeys("u").
                sendKeys("n").sendKeys("g").sendKeys(" ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").
                sendKeys("1").sendKeys(Keys.ENTER).
                perform();

        //  aramanin gerceklestigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());


        /*
       ==> shift tuşu otomasyon ile bu şekilde kullanılır. Shift tuşuna basmak için keyDown,
           shift ten çıkmak için keyUp kullanılır
         */

    }
}
