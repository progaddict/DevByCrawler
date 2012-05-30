package bsu.rfct.devbycrawler.core;



import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;


public class ConfigManagerTest {

    @Test
    public void testReadPositionsConfig() throws Exception {
        ArrayList<String> positions = ConfigManager.readPositionsConfig();
        Assert.assertEquals(positions.size(),20);
        Assert.assertEquals(positions.get(0),"Software Engineer");
        Assert.assertEquals(positions.get(5),"QA Engineer/ Tester");
        Assert.assertEquals(positions.get(8),"HR");
        Assert.assertEquals(positions.get(17),"QA Manager");
        Assert.assertEquals(positions.get(19),"Lead Software Engineer");
    }



    @Test
    public void testReadPlatformsConfig() throws Exception {
        ArrayList<String> platforms = ConfigManager.readPlatformsConfig();
        Assert.assertEquals(platforms.size(),18);
        Assert.assertEquals(platforms.get(0),"ABAP/4");
        Assert.assertEquals(platforms.get(4),"Android");
        Assert.assertEquals(platforms.get(8),"ObjectiveC/ MacOS/ iPhone");
        Assert.assertEquals(platforms.get(13),"HTML/ CSS/ JavaScript");
        Assert.assertEquals(platforms.get(17),"Flash/ Flex/ Action Script");
    }

}
