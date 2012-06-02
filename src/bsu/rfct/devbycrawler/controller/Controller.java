package bsu.rfct.devbycrawler.controller;



import bsu.rfct.devbycrawler.core.ConfigManager;
import bsu.rfct.devbycrawler.core.CrawlerResponse;
import bsu.rfct.devbycrawler.core.DevByCrawler;
import bsu.rfct.devbycrawler.core.UserQuery;

import java.util.ArrayList;



public class Controller {

    private DevByCrawler aDevByCrawler;

    public Controller() {
        aDevByCrawler = new DevByCrawler();
    }

    public ArrayList<String> getPositions() {
        return ConfigManager.readPositionsConfig();
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
