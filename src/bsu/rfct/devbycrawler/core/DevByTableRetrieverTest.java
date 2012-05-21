package bsu.rfct.devbycrawler.core;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;


/**
 * Unit tests for DevByTableRetriever.
 * TODO implement tests
 */
public class DevByTableRetrieverTest {

    private URL aURL;
    private HTMLTableInfo aTableInfo;
    private Set<String> someItemsToSelect;
    private UserQuery aUserQuery;
    private DevByTableRetriever aDevByTableRetriever;



    @BeforeMethod
    public void setUp() throws MalformedURLException {
        aURL = new URL("http://dev.by/salaries");
        aTableInfo = HTMLTableInfo.PLATFORMS_TABLE;
        someItemsToSelect = new HashSet<String>(10);
        someItemsToSelect.add(".NET");
        someItemsToSelect.add("1C");
        someItemsToSelect.add("ABAP/4");
        someItemsToSelect.add("Android");
        someItemsToSelect.add("C/C++");
        someItemsToSelect.add("Java");
        aUserQuery = new UserQuery(aURL,aTableInfo,someItemsToSelect);
        aDevByTableRetriever = new DevByTableRetriever();
    }



    @Test
    public void testRetrieveTable() throws Exception {

    }

}
