package Day08_Actions;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {

    @Test
    public void name() {

        System.out.println(System.getProperty("user.dir")); // C:\Users\USER\IdeaProjects\com.JUnit
        // Şuan ki içinde bulunduğum yolu gösterir.

        System.out.println(System.getProperty("user.home")); // C:\Users\USER
        // Geçerli kullanıcının ana dizinini verir.

        String dosyaYolu = "C:\\Users\\Public\\Desktop\\Google Chrome.lnk";
        System.out.println(Files.exists(Paths.get(dosyaYolu))); // true
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        ==> Bir web sitesinden indirdiğimiz ya da windows içinde oluşturduğumuz dosyanın
            indiğini ya da orada olduğunu test edebilmem için o dosyanın üzerine
            Shift tuşuna basılı olarak sağ click yapıp dosyanın yolunu kopyalayıp
            bir string değişkene atarız ve dosyayı doğrulamak için
            Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız.
         */

        /* 2. YOL
        String farkliBolum = System.getProperty("user.home");
        //"C:\\Users\\Public\\Desktop\\Google Chrome.lnk" --> masa üstündeki dosyanın yolu

        String ortakBolum = "\\Desktop\\Google Chrome.lnk"";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir

        System.out.println(masaUstuDosyaYolu); //"C:\\Users\\Public\\Desktop\\Google Chrome.lnk"

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        */

    }
}
