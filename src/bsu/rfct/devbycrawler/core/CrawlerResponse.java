package bsu.rfct.devbycrawler.core;



/**
 * Response from Crawler. Might be expanded/refactored/subclassed in future
 * to provide more flexibility/functionality/abstraction.
 */
public class CrawlerResponse {

    /**
     * Should be returned by a crawler in case of crawling
     * troubles (no such page, blank page, etc.)
     */
    public static final CrawlerResponse NULL_CRAWLER_RESPONSE = new CrawlerResponse(0);

    private double average;

    public CrawlerResponse(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

}
