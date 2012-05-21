package bsu.rfct.devbycrawler.core;



import javax.swing.table.AbstractTableModel;





/**
 * Retrieves tables from dev.by.
 */
public class DevByTableRetriever implements ITableRetriever {

    @Override
    public AbstractTableModel retrieveTable(UserQuery userQuery) {
        // TODO think about null objects like NULL_TABLE_MODEL.
        String aRawTable = getRawTable(userQuery);
        DevByTableModel aTable = composeDevByTableModel(aRawTable);
        return aTable;
    }



    /**
     * Retrieves "raw" table, i.e. one containing html code.
     * @param userQuery query information specified by a user.
     * @return string containing a raw table.
     */
    private String getRawTable(UserQuery userQuery) {
        // TODO impement url loading and html parsing. Java regex will help.
        return "";
    }



    /**
     * Composes a neat table for further handling.
     * @param rawTable string containing an html-ed table.
     * @return table model with desired data.
     */
    private DevByTableModel composeDevByTableModel(String rawTable) {
        // TODO implement raw html table processing
        return null;
    }

}
