package bsu.rfct.devbycrawler.core;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;





/**
 * Table model for dev.by.
 * Consists of 5 columns: item name, min, average, max, number of forms applied.
 */
public class DevByTableModel extends AbstractTableModel {

    private static Log logger = LogFactory.getLog(DevByTableModel.class);

    private String itemsName;
    private int numberOfRows;
    private ArrayList<String> items; // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH instead of usage of 4(!) arrays you could use something Map<String, ItemData> . And ItemData is simple POJO with getMin(), getMax(), getAverage() and so on. Then you would not need to deal with Object which is not quite safe. 
    private ArrayList<Double> min;
    private ArrayList<Double> average;
    private ArrayList<Double> max;
    private ArrayList<Double> numberOfForms;



    public DevByTableModel(String itemsName, ArrayList<String> items,
                           ArrayList<Double> min, ArrayList<Double> average, ArrayList<Double> max,
                           ArrayList<Double> numberOfForms ) {
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
        this.numberOfForms = new ArrayList<Double>(numberOfForms);
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
            case 5:
                return "number of forms";
        }
        logger.error("wrong column: " + column);
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        assert isColumnWithinBounds(columnIndex);
        if( columnIndex == 1 ) {
            return String.class;
        }
        if( 2 <= columnIndex && columnIndex <= 5 ) {
            return Double.class;
        }
        logger.error("wrong column: " + columnIndex);
        return Object.class;
    }



    @Override
    public int getRowCount() {
        return numberOfRows;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(!isCellWithinBounds(rowIndex,columnIndex)) {
            logger.error("wrong cell: " + rowIndex + " " + columnIndex);
            return "";
        }
        switch (columnIndex) {
            case 1:
                return items.get(rowIndex-1);
            case 2:
                return min.get(rowIndex-1);
            case 3:
                return average.get(rowIndex-1);
            case 4:
                return max.get(rowIndex-1);
            case 5:
                return numberOfForms.get(rowIndex-1);
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
