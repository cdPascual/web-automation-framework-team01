package com.saucedemo.test;

import base.CommonAPI;
import com.saucedemo.HomePage;
import com.saucedemo.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class HomePageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePageTest.class.getName());

    HomePage homepage;


    @Test
    public void checkLogoutFunctionality() {
        homepage = new HomePage(driver);
        homepage.logOut();
        LOG.info("Log out from website successful");

    }
}
