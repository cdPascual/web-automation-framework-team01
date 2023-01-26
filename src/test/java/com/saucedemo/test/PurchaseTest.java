package com.saucedemo.test;

import base.CommonAPI;
import com.saucedemo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(PurchaseTest.class.getName());
    //land on home page

    HomePage homePage;
    SauceLabsBackpackPage sauceLabsBackpackPage;

    @Test()
    public void successfullyPurchaseSauceLabsBackpack() {

        //validate the current URL
        homePage = new HomePage(driver);

        homePage.loginToWeb();
        String actualCurrentUrl = getCurrentUrl();
        String expectedCurrentUrl = "https://www.saucedemo.com/inventory.html";
        LOG.info("actual home page URL: " + actualCurrentUrl);
        Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
        LOG.info("land to Swag Labs home page success");

        //Select sauce Labs Backpack
        homePage.selectItem();
        LOG.info("Sauce labs Backpack was selected");

        //Validate Item page Url
        String actualUrl = getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
        LOG.info("actual page URL: " + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        LOG.info("land to Selected item page success");

        //Add the item to cart
        sauceLabsBackpackPage = new SauceLabsBackpackPage(driver);
        sauceLabsBackpackPage.clickAddToCart();
        LOG.info("Added to cart success");

        //click on the cart icon
        sauceLabsBackpackPage.clickOnCart();
        LOG.info("Click on cart Icon success");

        String currentWebUrl = getCurrentUrl();
        String expectedWebUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(currentWebUrl, expectedWebUrl);
        LOG.info("Landed on Your cart page");

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.itemPresentInCart();
        LOG.info("Item was added to cart and is displayed");

        yourCartPage.clickCheckoutButton();
        LOG.info("Checkout button click success");

        //Validate landing to Your Information page
        String currentInfoPageUrl = getCurrentUrl();
        String expectedInfoPageUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(currentWebUrl, expectedWebUrl);
        LOG.info("Landed on Your Information page success");

        //User enters firstname, lastname, zipcode and click continue button

        YourInfoPage infoPage = new YourInfoPage(driver);
        infoPage.enterUserInfo();
        infoPage.clickContinue();
        LOG.info("User info enter and click continue success");

        //Validate landing on checkout overview page
        String actualOverviewPageURL = getCurrentUrl();
        String expectedOverviewPageURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actualOverviewPageURL, expectedOverviewPageURL);
        LOG.info("Overview page validation success");

        //validate if correct item with correct price is displayed on the overview page and click finish
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.ifItemAndPriceDisplayed();
        overviewPage.clickFinish();
        LOG.info("Item and price display and click finish success");

        //Validate landing on checkout complete page

        String actualCheckoutCompletePageURL = getCurrentUrl();
        String expectedCheckoutCompletePageURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(actualCheckoutCompletePageURL, expectedCheckoutCompletePageURL);
        LOG.info("Checkout complete page validation success");

        //validate thank you message displayed and go back to homepage url
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.validateThanksMessage();
        checkoutCompletePage.goBackToHomePage();
        LOG.info("Validate thanks message and click back to home button success: purchase success");

        //validate home page landing
        String actualHomepageURL = getCurrentUrl();
        String expectedHomepageUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualHomepageURL, expectedHomepageUrl);
        LOG.info("Back to homepage success");
    }


    @Test
    public void purchaseItemWithoutProvidingUserInfo() {
        //validate the current URL
        homePage = new HomePage(driver);

        homePage.loginToWeb();
        String actualCurrentUrl = getCurrentUrl();
        String expectedCurrentUrl = "https://www.saucedemo.com/inventory.html";
        LOG.info("actual home page URL: " + actualCurrentUrl);
        Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
        LOG.info("land to Swag Labs home page success");

        //Select sauce Labs Backpack
        homePage.selectItem();
        LOG.info("Sauce labs Backpack was selected");

        //Validate Item page Url
        String actualUrl = getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
        LOG.info("actual page URL: " + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        LOG.info("land to Selected item page success");

        //Add the item to cart
        sauceLabsBackpackPage = new SauceLabsBackpackPage(driver);
        sauceLabsBackpackPage.clickAddToCart();
        LOG.info("Added to cart success");

        //click on the cart icon
        sauceLabsBackpackPage.clickOnCart();
        LOG.info("Click on cart Icon success");

        String currentWebUrl = getCurrentUrl();
        String expectedWebUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(currentWebUrl, expectedWebUrl);
        LOG.info("Landed on Your cart page");

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.itemPresentInCart();
        LOG.info("Item was added to cart and is displayed");

        yourCartPage.clickCheckoutButton();
        LOG.info("Checkout button click success");

        //Validate landing to Your Information page
        String currentInfoPageUrl = getCurrentUrl();
        String expectedInfoPageUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(currentWebUrl, expectedWebUrl);
        LOG.info("Landed on Your Information page success");

        //user tries to click continue without providing information
        YourInfoPage infoPage = new YourInfoPage(driver);
        infoPage.clickContinue();
        LOG.info("User does not provide info and click continue success");
        String error = infoPage.continueWithoutInfo();
        LOG.info("user gets a error message");

        //validate error message
        Assert.assertEquals(error, "Error: First Name is required");
        LOG.info("error message validation success");


    }

}
