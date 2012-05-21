package bsu.rfct.devbycrawler.core;





/**
 * Dev.by crawler.
 */
public class DevByCrawler implements ICrawler {

    private DevByTableRetriever aDevByTableRetriever;



    public DevByCrawler() {
        aDevByTableRetriever = new DevByTableRetriever();
    }



    @Override
    public CrawlerResponse crawl(UserQuery userQuery) {
        return CrawlerResponse.NULL_CRAWLER_RESPONSE;
    }

}
