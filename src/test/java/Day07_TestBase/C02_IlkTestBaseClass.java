package Day07_TestBase;

import Utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test() {
        driver.get("https://amazon.com");
    }
}
