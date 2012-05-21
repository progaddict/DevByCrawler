package bsu.rfct.devbycrawler.core;



import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



/**
 * Tests for DevByTableModel.
 */
public class DevByTableModelTest {

    String itemsName;
    String[] someItems;
    double[] someMinValues;
    double[] someAverageValues;
    double[] someMaxValues;
    DevByTableModel aTable;

    @BeforeSuite
    public void setUp() throws Exception {
        itemsName = "positions";
        someItems = new String[] {"position A","position B","position C","position D","position E"};
        someMinValues = new double[] {0,1,2,3,4};
        someAverageValues = new double[] {10,11,12,13,14};
        someMaxValues = new double[] {20,21,22,23,24};
        aTable = new DevByTableModel(itemsName,someItems,someMinValues,someAverageValues,someMaxValues);
    }

    @Test
    public void testGetColumnName() {
        Assert.assertEquals( aTable.getColumnName(1), itemsName );
        Assert.assertEquals( aTable.getColumnName(2), "min" );
        Assert.assertEquals( aTable.getColumnName(3), "average" );
        Assert.assertEquals( aTable.getColumnName(4), "max" );
    }

    @Test
    public void testGetColumnClass() {
        Assert.assertEquals( aTable.getColumnClass(1), String.class );
        Assert.assertEquals( aTable.getColumnClass(2), Double.class );
        Assert.assertEquals( aTable.getColumnClass(3), Double.class );
        Assert.assertEquals( aTable.getColumnClass(4), Double.class );
    }

    @Test
    public void testGetRowCount() {
        Assert.assertEquals( aTable.getRowCount(), someItems.length );
    }

    @Test
    public void testGetColumnCount() {
        Assert.assertEquals( aTable.getColumnCount(), 4 );
    }

    @Test
    public void testGetValueAt() {
        Assert.assertEquals( aTable.getValueAt(1,1), someItems[0] );
        Assert.assertEquals( aTable.getValueAt(2,1), someItems[1] );
        Assert.assertEquals( aTable.getValueAt(3,1), someItems[2] );
        Assert.assertEquals( aTable.getValueAt(4,1), someItems[3] );
        Assert.assertEquals( aTable.getValueAt(5,1), someItems[4] );
        Assert.assertEquals( aTable.getValueAt(1,2), new Double(someMinValues[0]) );
        Assert.assertEquals( aTable.getValueAt(5,2), new Double(someMinValues[4]) );
        Assert.assertEquals( aTable.getValueAt(1,3), new Double(someAverageValues[0]) );
        Assert.assertEquals( aTable.getValueAt(5,3), new Double(someAverageValues[4]) );
        Assert.assertEquals( aTable.getValueAt(1,4), new Double(someMaxValues[0]) );
        Assert.assertEquals( aTable.getValueAt(5,4), new Double(someMaxValues[4]) );
    }

}
