package Day06_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_Iframe {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {

        // https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");

        // YouTube videosunu calistiriniz
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("*//iframe")));
        driver.switchTo().frame(iframeList.get(0));

        WebElement youtubePlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubePlayButton.click();

        /*
        ==> Bir web sitesinde bir video(youtube vb..) varsa <iframe> tag'i içerisinde
        bu video'yu direk locate edip çalıştırmmak dinamik olmaz çünkü link değişebilir
        ve locate'imiz çalışmaz.
        ==> Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip
        sonrasında play tuşunu locate edip çalıştırabiliriz.
         */
    }
}
