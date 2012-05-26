package bsu.rfct.devbycrawler.core;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Set;



/**
 * Retrieves tables from dev.by.
 */
public class DevByTableRetriever implements ITableRetriever {

    private Set<String> userDefinedItems;
    private static final String TABLE_ROW_TAG = "tr";
    private static final int EXPECTED_NUMBER_OF_ITEMS = 20;
    private ArrayList<String> items;
    private ArrayList<Double> min;
    private ArrayList<Double> average;
    private ArrayList<Double> max;
    private ArrayList<Double> numberOfForms;

    /** scraps data from html element to items, min, max, etc. */
    private void handleTableRow( Element tableRow ) {
        Elements tableRowElements = tableRow.children();
        // handle item name and number of forms
        Element tdElement = tableRowElements.get(0);
        Element aElement = tdElement.children().get(0);
        String itemName = aElement.text().trim();
        // do we need to save it ?
        if( !userDefinedItems.contains(itemName)) {
            return;
        }
        items.add(itemName);
        aElement.remove();
        String rawTagContents = tdElement.text();
        String numberToParse = rawTagContents.replaceAll("[^0-9]","");
        numberOfForms.add(Double.parseDouble(numberToParse));
        // now handle min, max and average
        String stringMin = tableRowElements.get(1).text().trim();
        String stringAverage = tableRowElements.get(2).text().trim();
        String stringMax = tableRowElements.get(3).text().trim();
        min.add(Double.parseDouble(stringMin));
        average.add(Double.parseDouble(stringAverage));
        max.add(Double.parseDouble(stringMax));
    }

    @Override
    public AbstractTableModel retrieveTable(UserQuery userQuery) {
        this.userDefinedItems = userQuery.getItemsToSelect();
        try {
            Document doc = Jsoup.connect(userQuery.getUrlToCrawl().toExternalForm()).get();
            Element table = doc.getElementById(userQuery.getTableToRetrieve().getTableID());
            Elements rows = table.getElementsByTag(TABLE_ROW_TAG);
            // first row contains table header, so we remove it
            rows.remove(0);
            // process table row by row
            items = new ArrayList<String>(EXPECTED_NUMBER_OF_ITEMS);
            min = new ArrayList<Double>(EXPECTED_NUMBER_OF_ITEMS);
            average = new ArrayList<Double>(EXPECTED_NUMBER_OF_ITEMS);
            max = new ArrayList<Double>(EXPECTED_NUMBER_OF_ITEMS);
            numberOfForms = new ArrayList<Double>(EXPECTED_NUMBER_OF_ITEMS);
            for (Element element : rows) {
                handleTableRow(element);
            }
            return new DevByTableModel(userQuery.getTableToRetrieve().getTableID(),
                    items,min,average,max,numberOfForms);
        }
        // TODO think what might go wrong, i.e. exception types to handle
        catch (Exception trouble) {
            // TODO logging
        }
        return null; // in case of trouble (try failed)
    }

}
