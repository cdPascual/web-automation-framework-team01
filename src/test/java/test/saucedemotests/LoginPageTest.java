package test.saucedemotests;

import base.CommonAPI;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPageTest.class.getName());

    LoginPage loginPage;
    HomePage homepage;

    @Test
    public void successfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername();
        loginPage.typePass();
        loginPage.clickOnSubmit();
        LOG.info("Login success");

        //HomePage validation
        homepage= new HomePage(driver);
        String actualHomepageHeaderText= homepage.validateHomepageHeaderText();
        String expectedHomepageHeaderText= "PRODUCTS";
        Assert.assertEquals(actualHomepageHeaderText,expectedHomepageHeaderText);
        LOG.info("page validation success");
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
