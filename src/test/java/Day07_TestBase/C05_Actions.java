package Day07_TestBase;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe, dropHere).perform();

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement text = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualText = text.getText();
        Assert.assertEquals("Dropped!",actualText);
    }
}
