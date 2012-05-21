package bsu.rfct.devbycrawler.core;



/**
 * Crawler interface. Real classes should implement crawling algorithm through
 * this interface (like in the strategy pattern).
 */
public interface ICrawler {

    /** Crawl and get the answer. */
    public CrawlerResponse crawl( UserQuery userQuery );

}
