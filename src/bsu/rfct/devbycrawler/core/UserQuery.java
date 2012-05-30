package bsu.rfct.devbycrawler.core;


import java.util.HashSet;
import java.util.Set;


/**
 * Encapsulates user request data such as URL, user selected items to query
 * and table to parse. Might be expanded/refactored/subclassed in future
 * to provide more flexibility/functionality/abstraction.
 */
public class UserQuery {

    private String urlToCrawl;
    private HTMLTableInfo tableToRetrieve;
    private Set<String> itemsToSelect;

    public UserQuery(String urlToCrawl, HTMLTableInfo tableToRetrieve, Set<String> itemsToSelect) {
        assert urlToCrawl != null;
        assert tableToRetrieve != null;
        assert itemsToSelect != null;
        this.urlToCrawl = urlToCrawl;
        this.tableToRetrieve = tableToRetrieve;
        this.itemsToSelect = new HashSet<String>(itemsToSelect);
    }

    public String getUrlToCrawl() {
        return urlToCrawl;
    }

    public HTMLTableInfo getTableToRetrieve() {
        return tableToRetrieve;
    }

    public Set<String> getItemsToSelect() {
        return new HashSet<String>(itemsToSelect);
    }

}
