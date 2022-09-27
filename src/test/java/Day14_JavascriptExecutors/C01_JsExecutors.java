package Day14_JavascriptExecutors;

import Utilities.JavascriptExecutorCode;
import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C01_JsExecutors extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        // Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim
        WebElement careers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", careers);

        // Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();", careers);
    }
}
