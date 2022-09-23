package Day09_Waits;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");

        // Product bölümüne girelim.
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        // ilk ürüne tıklayalım.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}
