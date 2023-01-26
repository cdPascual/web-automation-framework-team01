package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestFramework extends CommonAPI {

    Logger Log = LogManager.getLogger(TestFramework.class.getName());
    @Test
    public void TestAutomation() throws IOException {
        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        Log.info("basic automation a success");
//        File file = new File("config.properties");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getPath());
    }
}
