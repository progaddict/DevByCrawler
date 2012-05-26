package bsu.rfct.devbycrawler.core;



/**
 * Contains information about HTML table to parse.
 * Basically it's enumeration, but it might be expanded in future.
 */
public final class HTMLTableInfo {

    /** Platforms/language table info */
    public static final HTMLTableInfo PLATFORMS_TABLE = new HTMLTableInfo("platform-table");

    /** Positions table info */
    public static final HTMLTableInfo POSITIONS_TABLE = new HTMLTableInfo("position-table");

    /** Positions table info */
    public static HTMLTableInfo CITIES_TABLE = new HTMLTableInfo("city-table");



    private final String tableID;

    private HTMLTableInfo(String tableID) {
        assert tableID != null;
        assert !tableID.equals("");
        this.tableID = tableID;
    }



    /**
     * Get id of the table HTML element.
     * Example: < table id="city-table" > ...
     * */
    public String getTableID() {
        return tableID;
    }

}
