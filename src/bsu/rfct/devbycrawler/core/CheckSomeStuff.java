package bsu.rfct.devbycrawler.core;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*import javax.swing.text.*;
import javax.swing.text.html.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.Reader;*/


/** just a rough draft for a code to try. nothing really special */
public class CheckSomeStuff {

    @Test
    public void aTest() throws Exception {
        String str = "   260  анкет  ";
        str = str.replaceAll("[^0-9]","");
        Double d = Double.parseDouble(str);
        System.out.println(d);
        System.out.println("Done");
        //System.in.read();
    }
}
