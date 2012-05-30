package bsu.rfct.devbycrawler.core;



import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;


/**
 * Tests for UserQuery
 */
public class UserQueryTest {

    @Test
    public void testImmutability() throws MalformedURLException {
        String aURL = "http://dev.by/salaries";
        HTMLTableInfo aTable = HTMLTableInfo.PLATFORMS_TABLE;
        HashSet<String> aSet = new HashSet<String>(10);
        aSet.add(".NET");
        aSet.add("1C");
        aSet.add("HTML/ CSS/ JavaScript");
        UserQuery aQuery = new UserQuery(aURL, aTable, aSet);
        Assert.assertEquals(aQuery.getTableToRetrieve().getTableID(), aTable.getTableID());
        aSet.add("x");
        Assert.assertEquals(aQuery.getItemsToSelect().size(), 3);
        Set<String> stringSet = aQuery.getItemsToSelect();
        stringSet.add("x");
        stringSet.add("y");
        stringSet.add("z");
        Assert.assertEquals(aQuery.getItemsToSelect().size(), 3);
    }

}
