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
	// TODO AUTHOR popretinskaya_e 07.06.2012 HIGH this test is not very good since it tests several things. Usually 1 unit test should test 1 thing only. I also recommend to read some articles/books about best practices for Unit testing. My favorite book is "The Art of Unit Testing" http://artofunittesting.com/
    @Test
    public void testImmutability() throws MalformedURLException {   
        String aURL = "http://dev.by/salaries";
        HTMLTableInfo aTable = HTMLTableInfo.PLATFORMS_TABLE;
        HashSet<String> aSet = new HashSet<String>(10); // TODO AUTHOR popretinskaya_e 07.06.2012 LOW aSet is not meaningful variable name
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
