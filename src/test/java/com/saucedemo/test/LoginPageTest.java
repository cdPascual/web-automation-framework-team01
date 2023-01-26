package com.saucedemo.test;

import base.CommonAPI;
import com.saucedemo.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPageTest.class.getName());

    LoginPage loginPage;

    @Test
    public void successfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername();
        loginPage.typePass();
        loginPage.clickOnSubmit();

        String currentTitle = getCurrentTitle();
        Assert.assertEquals(getCurrentTitle(), "Swag Labs");
        LOG.info("Home page title validation success");
    }

    @Test
    public void unsuccessfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.typeIncorrectUser();

        loginPage.typeIncorrectPass();

        loginPage.clickSubmit();
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        LOG.info("error message validation success");


    }


}
