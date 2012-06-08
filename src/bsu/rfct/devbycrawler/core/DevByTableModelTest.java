package bsu.rfct.devbycrawler.core;



import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Tests for DevByTableModel.
 */
public class DevByTableModelTest {

    private String itemsName;
    private ArrayList<String> someItems;
    private ArrayList<Double> someMinValues;
    private ArrayList<Double> someAverageValues;
    private ArrayList<Double> someMaxValues;
    private ArrayList<Double> someNumberOfFormsValues;
    private DevByTableModel aTable;

    @BeforeSuite
    public void setUp() throws Exception {
        itemsName = "positions";
        someItems = new ArrayList<String>(Arrays.asList(new String[] {"position A","position B","position C","position D","position E"}));
        someMinValues = new ArrayList<Double>(Arrays.asList(new Double[] {0d,1d,2d,3d,4d}));
        someAverageValues = new ArrayList<Double>(Arrays.asList(new Double[] {10d,11d,12d,13d,14d}));
        someMaxValues = new ArrayList<Double>(Arrays.asList(new Double[] {20d,21d,22d,23d,24d}));
        someNumberOfFormsValues = new ArrayList<Double>(Arrays.asList(new Double[] {10d,20d,200d,2d,4d}));
        aTable = new DevByTableModel(itemsName,someItems,someMinValues,someAverageValues,someMaxValues,someNumberOfFormsValues);
    }

    @Test
    public void testGetColumnName() {
        Assert.assertEquals( aTable.getColumnName(1), itemsName );
        Assert.assertEquals( aTable.getColumnName(2), "min" );
        Assert.assertEquals( aTable.getColumnName(3), "average" );
        Assert.assertEquals( aTable.getColumnName(4), "max" );
        Assert.assertEquals( aTable.getColumnName(5), "number of forms" );
    }

    @Test
    public void testGetColumnClass() {
        Assert.assertEquals( aTable.getColumnClass(1), String.class );
        Assert.assertEquals( aTable.getColumnClass(2), Double.class );
        Assert.assertEquals( aTable.getColumnClass(3), Double.class );
        Assert.assertEquals( aTable.getColumnClass(4), Double.class );
        Assert.assertEquals( aTable.getColumnClass(5), Double.class );
    }

    @Test
    public void testGetRowCount() {
        Assert.assertEquals( aTable.getRowCount(), someItems.size() );
    }

    @Test
    public void testGetColumnCount() {
        Assert.assertEquals( aTable.getColumnCount(), 5 );
    }

    // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH Good unit test should test 1 thing only. You might split test below to several tests.
    @Test
    public void testGetValueAt() {
        for(int i=0; i<someItems.size(); i++) {
            Assert.assertEquals( aTable.getValueAt(i+1,1), someItems.get(i) );
        }
        for(int i=0; i<someItems.size(); i++) {
            Assert.assertEquals( aTable.getValueAt(i+1,2), someMinValues.get(i) );
        }
        for(int i=0; i<someItems.size(); i++) {
            Assert.assertEquals( aTable.getValueAt(i+1,3), someAverageValues.get(i) );
        }
        for(int i=0; i<someItems.size(); i++) {
            Assert.assertEquals( aTable.getValueAt(i+1,4), someMaxValues.get(i) );
        }
        for(int i=0; i<someItems.size(); i++) {
            Assert.assertEquals( aTable.getValueAt(i+1,5), someNumberOfFormsValues.get(i) );
        }
    }

    @Test
    public void testImmutability() {
        someItems.set(0,"position X");
        Assert.assertEquals( aTable.getValueAt(1,1), "position A" );
        someMinValues.set(0,-10d);
        Assert.assertEquals( aTable.getValueAt(1,2), 0d );
        someAverageValues.set(0,-10d);
        Assert.assertEquals( aTable.getValueAt(1,3), 10d );
        someMaxValues.set(0,-10d);
        Assert.assertEquals( aTable.getValueAt(1,4), 20d );
        someNumberOfFormsValues.set(0,-10d);
        Assert.assertEquals( aTable.getValueAt(1,5), 10d );
    }

}
