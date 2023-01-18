package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFramework extends CommonAPI {

    Logger Log = LogManager.getLogger(TestFramework.class.getName());
    @Test
    public void TestAutomation(){
        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,"Google");
        Log.info("basic automation a success");
    }
}
