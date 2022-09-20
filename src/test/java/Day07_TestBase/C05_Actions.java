package Day07_TestBase;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() {

        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    }
}
