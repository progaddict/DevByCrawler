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
            for(int i=1; i<=numberOfRows; i++) { // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH this loop would be much better if instead/inside of tableModel you would use Map and custom POJO with min/max/average/numberOfForms values
                Double average = (Double)aDevByTableModel.getValueAt(i,3); // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH direct class cast in most cases is not good. You should avoid it. Besides 3 and 5 are magic numbers.
                Double numberOfForms = (Double)aDevByTableModel.getValueAt(i,5);
                totalNumberOfForms += numberOfForms;
                result += numberOfForms*average;
            }
            assert totalNumberOfForms != 0; // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH don't use Assert for logic! Also remember that Asserts could be turned off on virtual machine and it's not guaranteed that they would be performed (by default, assertions are disabled at runtime.). Read more http://docs.oracle.com/javase/6/docs/technotes/guides/language/assert.html
            if( totalNumberOfForms == 0 ) {
                logger.error("number of forms is zero! I won't divide by zero!"); // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH I think in this case it would be better to throw meaningful custom Exeception (for example NoRequestedDataException) and handle it in UI (e.g. show meaningful message to User)
                return 0.0d;
            }
            result /= totalNumberOfForms;
        }
        // TODO what might go wrong?
        catch (Exception trouble) {
            logger.error("something went wrong: " + trouble.getMessage() + ". returning 0.");
            return 0.0d; // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH usually it's not good to use return values in case when something went wrong. Usually it's better to throw exception and handle it on higher level. Besides if you use return value to show that something went wrong then use unusual value. 0 is not good in your case (negative value for example would show that something is not good)
        }
        return result;
    }

}
