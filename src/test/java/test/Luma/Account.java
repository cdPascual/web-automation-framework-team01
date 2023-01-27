package test.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Luma.HomePage;
import pages.Luma.LoginPage;
import pages.Luma.WhatsNewPage;
import utility.Utility;

public class Account extends CommonAPI {
    Logger LOG = LogManager.getLogger(Account.class.getName());

    @Test
    public void invalidEmailAddress() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        //String password = ConnectDB.getTableColumnData("select * from credentials","password").get(0);


        homePage.clickOnLoginButton();

        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("crazycray@dhsj");
        loginPage.typePassword("password123");

        loginPage.clickOnConnectButton();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Please enter a valid email address (Ex: johndoe@domain.com).");
        LOG.info("error message validation success");

    }

    @Test
    public void validCredentials() throws InterruptedException {
//        HomePage homePage = new HomePage(getDriver());
//        WhatsNewPage whatsNewPage= new WhatsNewPage(getDriver());
//        LoginPage loginPage = new LoginPage(getDriver());
//        String email = Utility.getProperties().getProperty("magentoLuma.username");
//        String password = Utility.getProperties().getProperty("magentoLuma.password");
//        //String password = ConnectDB.getTableColumnData("select * from credentials","password").get(0);
//
//
//        homePage.clickOnLoginButton();
//
//        String title = getCurrentTitle();
//        Assert.assertEquals(title, "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
//        LOG.info("login title page validation success");
//
//        loginPage.typeEmailAddress(email);
//        loginPage.typePassword(password);
//
//        loginPage.clickOnConnectButton();
//
//        String error = loginPage.getErrorMessage();
//        Assert.assertEquals(error, "Please enter a valid email address (Ex: johndoe@domain.com).");
//        LOG.info("error message validation success");

    }
}
