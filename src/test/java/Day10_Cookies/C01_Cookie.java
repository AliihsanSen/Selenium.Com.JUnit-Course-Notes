package Day10_Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // -tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        int count = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(count + ".ci cookie : " + each);
            System.out.println(count + ".ci name : " + each.getName());
            System.out.println(count + ".ci value: " + each.getValue());
            count++;
        }
        /* Lambda ile yazılması
        cookiesSet.stream().forEach(t -> System.out.println("name : " + t.getName() + " value :" + t.getValue()));
         */

        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookiesSet.size();
        Assert.assertTrue(cookieSayisi > 5);

        // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookiesSet
        ) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(newCookie);
        cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        count = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(count + ".ci cookie : " + each);
            System.out.println(count + ".ci name : " + each.getName());
            System.out.println(count + ".ci value: " + each.getValue());
            count++;
        }
        // 6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookiesSet.contains(newCookie));

        // 7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        count = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(count + ".ci cookie : " + each);
            System.out.println(count + ".ci name : " + each.getName());
            System.out.println(count + ".ci value: " + each.getValue());
            count++;
        }

        // 8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        Assert.assertTrue(cookiesSet.isEmpty());
    }
}
