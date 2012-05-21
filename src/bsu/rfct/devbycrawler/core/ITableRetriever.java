package bsu.rfct.devbycrawler.core;

import javax.swing.table.AbstractTableModel;



/**
 * Interface for retrieving tables. Should be use by crawler.
 */
public interface ITableRetriever {

    public AbstractTableModel retrieveTable(UserQuery userQuery);

}
