package Day07_TestBase;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() {

        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actual = driver.switchTo().alert().getText();
        String expected = "You selected a context menu";
        Assert.assertEquals(actual, expected);

        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        String expectedText = "Elemental Selenium";
        String actualText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals(actualText, expectedText);

    }
}
