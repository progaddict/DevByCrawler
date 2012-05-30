package bsu.rfct.devbycrawler.controller;



import bsu.rfct.devbycrawler.core.ConfigManager;
import bsu.rfct.devbycrawler.core.CrawlerResponse;
import bsu.rfct.devbycrawler.core.DevByCrawler;
import bsu.rfct.devbycrawler.core.UserQuery;

import java.util.ArrayList;



public class Controller {

    private DevByCrawler aDevByCrawler;
    private UserQuery aUserQuery;
    private CrawlerResponse aCrawlerResponse;

    public Controller() {
        aDevByCrawler = new DevByCrawler();
    }

    public ArrayList<String> getPositions() {
        return ConfigManager.readPositionsConfig();
    }

    public ArrayList<String> getSiteList() {
        ArrayList<String> siteList = new ArrayList<String>(1);
        siteList.add("http://dev.by/salaries");
        return siteList;
    }

}
