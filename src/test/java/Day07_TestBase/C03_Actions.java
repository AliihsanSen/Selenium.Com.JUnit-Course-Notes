package Day07_TestBase;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() {
        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // Account menusunden create a list linkine tıklayalım.
        WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions action = new Actions(driver);
        action.moveToElement(accountList).perform();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi taktirde HTML kodlari
        arasında web elementi bulur ama ulaşamadığı için
        ElemenNotInteractableException: element not interactable exception'i fırlatır.
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
