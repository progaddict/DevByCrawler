package bsu.rfct.devbycrawler.controller;



import bsu.rfct.devbycrawler.core.ConfigManager;
import bsu.rfct.devbycrawler.core.CrawlerResponse;
import bsu.rfct.devbycrawler.core.DevByCrawler;
import bsu.rfct.devbycrawler.core.UserQuery;

import java.util.ArrayList;


// TODO AUTHOR popretinskaya_e 07.06.2012 LOW Name Controller is too general. Be more specific.
public class Controller {

    private DevByCrawler aDevByCrawler; // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH field type should be ICrawler. Use interfaces instead of concrete classes where you can. This will make your application more flexible (dependency injection)

    public Controller() {
        aDevByCrawler = new DevByCrawler();
    }

    public ArrayList<String> getPositions() { // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH return value should be List, not ArrayList. It's better to return more generic type. There are exceptions though (for example for GWT sometimes it's better to use concrete type to optimize how GWT compiles Java code to JavaScript) but not in your case
        return ConfigManager.readPositionsConfig(); // TODO AUTHOR popretinskaya_e 07.06.2012 HIGH it's not reasonable every time read from config if config is not changed. I would recommend to read only once.
    }

    public ArrayList<String> getPlatforms() {
        return ConfigManager.readPlatformsConfig();
    }

    public ArrayList<String> getSiteList() {
        // TODO think about config file for sites
        ArrayList<String> siteList = new ArrayList<String>(1);
        siteList.add("http://dev.by/salaries");
        return siteList;
    }

    public Double getAverage(UserQuery userQuery) {
        CrawlerResponse response = aDevByCrawler.crawl(userQuery);
        return response.getAverage();
    }

}
