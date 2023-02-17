package test.saucedemotests;

import base.CommonAPI;
import com.saucedemo.pages.CheckoutOverviewPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.YourCartPage;
import com.saucedemo.pages.YourInfoPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YourInfoPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(YourInfoPageTest.class.getName());


    HomePage homePage;
    @Test
    public void testFeaturesInInfoPage(){
        homePage= new HomePage(driver);
        homePage.loginToWeb();
        LOG.info("Log in to website success");
        String actualHomepageHeaderText= homePage.validateHomepageHeaderText();
        Assert.assertEquals(actualHomepageHeaderText, "PRODUCTS");
        LOG.info("Home page landing success");
        homePage.cartIcon.click();
        YourCartPage cartPage= new YourCartPage(driver);
        String actualCartPageHeaderText= cartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(actualCartPageHeaderText, "YOUR CART");
        LOG.info("Your cart page landing success");
        cartPage.clickCheckoutButton();
        YourInfoPage infoPage= new YourInfoPage(driver);
        String actualInfoPageHeaderText= infoPage.validateInfoPageHeaderText();
        Assert.assertEquals(actualInfoPageHeaderText, "CHECKOUT: YOUR INFORMATION");
        LOG.info("Your info page landing success");
        infoPage.checkIfFeaturesAreDisplayed();
        infoPage.cancelButtonClickOutcome();
        String cartPageHeaderText= cartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(cartPageHeaderText, "YOUR CART");
        cartPage.clickCheckoutButton();
        String infoPageHeaderText=infoPage.validateInfoPageHeaderText();
        Assert.assertEquals(infoPageHeaderText, "CHECKOUT: YOUR INFORMATION");
        LOG.info("Back to info page validation success");
        infoPage.enterUserInfoInAllFields();
        infoPage.continueButtonClickOutcome();
        CheckoutOverviewPage overviewPage= new CheckoutOverviewPage(driver);
        String actualOverviewPageHeaderText= overviewPage.validateOverviewPageHeaderText();
        Assert.assertEquals(actualOverviewPageHeaderText, "CHECKOUT: OVERVIEW");
        LOG.info("Checkout overview page landing success");
    }



@Test
    public void testInputUserInfoThenClickContinueProbAcc(){
        homePage= new HomePage(driver);
        homePage.loginToWebUsingProbCredentials();

        String actualHomepagePageHeader= homePage.validateHomepageHeaderText();
        Assert.assertEquals(actualHomepagePageHeader, "PRODUCTS");
    LOG.info("Homepage on problem account landing success");

        homePage.cartIcon.click();
        YourCartPage cartPage=new YourCartPage(driver);
        String actualCartPageHeader=cartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(actualCartPageHeader, "YOUR CART");
    LOG.info("Cart page on problem account landing success");
        cartPage.clickCheckoutButton();
        YourInfoPage infoPage= new YourInfoPage(driver);
        String actualInfoPageHeader= infoPage.validateInfoPageHeaderText();
        Assert.assertEquals(actualInfoPageHeader, "CHECKOUT: YOUR INFORMATION");
    LOG.info("Info page on problem account landing success");
        infoPage.enterUserInfoInAllFields();
        LOG.info("User info Entered");
        String actualTextEnteredInFirstNameField=infoPage.userFirstnameBox.getAttribute("value");
        Assert.assertEquals(actualTextEnteredInFirstNameField, "Sam");
        LOG.info("User info Entered incorrectly");



}


}
