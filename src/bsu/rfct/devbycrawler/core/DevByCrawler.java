package bsu.rfct.devbycrawler.core;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Dev.by crawler.
 */
public class DevByCrawler implements ICrawler {

    private static Log logger = LogFactory.getLog(DevByCrawler.class);

    private DevByTableRetriever aDevByTableRetriever;
    private DevByTableModel aDevByTableModel;
    private CrawlerResponse aCrawlerResponse;



    public DevByCrawler() {
        aDevByTableRetriever = new DevByTableRetriever();
    }



    @Override
    public CrawlerResponse crawl(UserQuery userQuery) {
        aCrawlerResponse = CrawlerResponse.NULL_CRAWLER_RESPONSE;
        try {
            aDevByTableModel = (DevByTableModel) aDevByTableRetriever.retrieveTable(userQuery);
            if( aDevByTableModel != null ) {
                aCrawlerResponse = new CrawlerResponse( calculateAverage() );
            }
        }
        // TODO think what might go wrong
        catch( Exception trouble ) {
            logger.error("something went wrong: " + trouble.getMessage() + ". returning null response.");
            return CrawlerResponse.NULL_CRAWLER_RESPONSE;
        }
        return aCrawlerResponse;
    }



    private double calculateAverage() {
        int numberOfItems = aDevByTableModel.getRowCount();
        Double result = 0.0d;
        try {
            final int numberOfRows = aDevByTableModel.getRowCount();
            Double totalNumberOfForms = 0.0d;
            for(int i=1; i<=numberOfRows; i++) {
                Double average = (Double)aDevByTableModel.getValueAt(i,3);
                Double numberOfForms = (Double)aDevByTableModel.getValueAt(i,5);
                totalNumberOfForms += numberOfForms;
                result += numberOfForms*average;
            }
            assert totalNumberOfForms != 0;
            if( totalNumberOfForms == 0 ) {
                logger.error("number of forms is zero! I won't divide by zero!");
                return 0.0d;
            }
            result /= totalNumberOfForms;
        }
        // TODO what might go wrong?
        catch (Exception trouble) {
            logger.error("something went wrong: " + trouble.getMessage() + ". returning 0.");
            return 0.0d;
        }
        return result;
    }

}
