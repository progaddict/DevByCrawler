package bsu.rfct.devbycrawler.core;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;


/**
 * Unit tests for DevByTableRetriever.
 * TODO implement tests
 */
public class DevByTableRetrieverTest {

    private String aURL;
    private HTMLTableInfo aTableInfo;
    private Set<String> someItemsToSelect;
    private UserQuery aUserQuery;
    private DevByTableRetriever aDevByTableRetriever;



    @BeforeMethod
    public void setUp() throws Exception {
        aURL = "http://dev.by/salaries";
        aTableInfo = HTMLTableInfo.PLATFORMS_TABLE;
        someItemsToSelect = new HashSet<String>(10);
        someItemsToSelect.add(".NET");
        someItemsToSelect.add("ABAP/4");
        someItemsToSelect.add("Android");
        someItemsToSelect.add("C/C++");
        someItemsToSelect.add("Java");
        aUserQuery = new UserQuery(aURL,aTableInfo,someItemsToSelect);
        aDevByTableRetriever = new DevByTableRetriever();
    }


// TODO AUTHOR popretinskaya_e 07.06.2012 HIGH test below is not real unit test. Test should perform assertion and you are not checking anything. You only print something to console.
    @Test
    public void testRetrieveTable() throws Exception {
        DevByTableModel aTable = (DevByTableModel) aDevByTableRetriever.retrieveTable(aUserQuery);
        int rowNumber = aTable.getRowCount();
        int colNumber = aTable.getColumnCount();
        System.out.println("rows = " + rowNumber + "   cols = " + colNumber); // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH Do not use System.out in your code. Even in tests. This is really BAD practice
        String header = "";
        for(int i=1; i<=colNumber; i++) {
            header = header + aTable.getColumnName(i) + "\t\t";
        }
        System.out.println(header);
        for(int i=1; i<=rowNumber; i++) {
            for(int j=1; j<=colNumber; j++) {
                System.out.print( aTable.getValueAt(i,j) + "\t\t" );
            }
            System.out.println();
        }
        System.out.println("Done");
        System.in.read(); // just to prevent clearing console
    }

}
