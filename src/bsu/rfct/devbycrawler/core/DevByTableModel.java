package bsu.rfct.devbycrawler.core;



import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;





/**
 * Table model for dev.by. Consists of 4 columns: item name, min, average, max.
 */
public class DevByTableModel extends AbstractTableModel {

    private String itemsName;
    private int numberOfRows;
    private ArrayList<String> items;
    private ArrayList<Double> min;
    private ArrayList<Double> average;
    private ArrayList<Double> max;



    public DevByTableModel(String itemsName, ArrayList<String> items, ArrayList<Double> min, ArrayList<Double> average, ArrayList<Double> max) {
        assert itemsName != null;
        assert !itemsName.equals("");
        assert items != null;
        assert min != null;
        assert average != null;
        assert max != null;
        this.itemsName = itemsName;
        this.numberOfRows = items.size();
        this.items = new ArrayList<String>(items);
        this.min = new ArrayList<Double>(min);
        this.average = new ArrayList<Double>(average);
        this.max = new ArrayList<Double>(max);
    }



    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 1:
                return itemsName;
            case 2:
                return "min";
            case 3:
                return "average";
            case 4:
                return "max";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        assert isColumnWithinBounds(columnIndex);
        if( columnIndex == 1 ) {
            return String.class;
        }
        if( 2 <= columnIndex && columnIndex <= 4 ) {
            return Double.class;
        }
        return Object.class;
    }



    @Override
    public int getRowCount() {
        return numberOfRows;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        assert isCellWithinBounds(rowIndex, columnIndex);
        switch (columnIndex) {
            case 1:
                return items.get(rowIndex-1);
            case 2:
                return min.get(rowIndex-1);
            case 3:
                return average.get(rowIndex-1);
            case 4:
                return max.get(rowIndex-1);
        }
        return "";
    }



    private boolean isRowWithinBounds(int rowIndex) {
        return 0 < rowIndex && rowIndex <= getRowCount();
    }

    private boolean isColumnWithinBounds(int columnIndex) {
        return 0 < columnIndex && columnIndex <= getColumnCount();
    }

    private boolean isCellWithinBounds(int rowIndex, int columnIndex) {
        return isRowWithinBounds(rowIndex) && isColumnWithinBounds(columnIndex);
    }

}
