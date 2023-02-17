package test.saucedemotests;

import base.CommonAPI;
import com.saucedemo.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
        String actualHomePageText = homePage.validateHomepageHeaderText();
        String expectedHomepageText = "PRODUCTS";
        LOG.info("actual home page header title: " + actualHomePageText);
        Assert.assertEquals(actualHomePageText, expectedHomepageText);
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

        YourCartPage yourCartPage = new YourCartPage(driver);
        String currentCartPageText = homePage.validateHomepageHeaderText();
        String expectedCartPageText = "YOUR CART";
        Assert.assertEquals(currentCartPageText, expectedCartPageText);
        LOG.info("Landed on Your cart page");


        yourCartPage.itemPresentInCart();
        LOG.info("Item was added to cart and is displayed");
        yourCartPage.itemInCartQuantity.isDisplayed();
        String actualQuantityOfItem=yourCartPage.itemInCartQuantity.getText().substring(0);
        String expectedQuantityOfItem="1";
        Assert.assertEquals(actualQuantityOfItem,expectedQuantityOfItem);
        LOG.info("Item quantity in cart validation success");
        yourCartPage.clickCheckoutButton();
        LOG.info("Checkout button click success");

        //Validate landing to Your Information page
        YourInfoPage infoPage = new YourInfoPage(driver);
        String currentInfoPageText = infoPage.validateInfoPageHeaderText();
        String expectedInfoPageText = "CHECKOUT: YOUR INFORMATION";
        Assert.assertEquals(currentInfoPageText, expectedInfoPageText);
        LOG.info("Landed on Your Information page success");
        LOG.info("Landed on Your Information page success");

        //User enters firstname, lastname, zipcode and click continue button
        infoPage.enterUserInfo();
        infoPage.clickContinue();
        LOG.info("User info enter and click continue success");

        //Validate landing on checkout overview page
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        String actualOverviewPageText = overviewPage.validateOverviewPageHeaderText();
        String expectedOverviewPageText = "CHECKOUT: OVERVIEW";
        Assert.assertEquals(actualOverviewPageText, expectedOverviewPageText);
        LOG.info("Overview page validation success");

        //validate if correct item with correct price is displayed on the overview page and click finish

        overviewPage.ifItemAndPriceDisplayed();
        String itemPrice= overviewPage.totalForItem.getText().substring(13, 18);
        String ItemTax= overviewPage.totalTax.getText().substring(6,9);

        float itemPriceInNumbers= Float.parseFloat(itemPrice);
        float itemTaxInNumbers=Float.parseFloat(ItemTax);

        float allTotal= itemPriceInNumbers+itemTaxInNumbers;
        String actualAllTotal= Float.toString(allTotal);
        LOG.info("Item price + tax = 32.39 validation success");

        Assert.assertEquals(actualAllTotal, "32.39");
        overviewPage.clickFinish();
        LOG.info("Item and price display and click finish success");

        //Validate landing on checkout complete page
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualCheckoutCompletePageText = checkoutCompletePage.validateHomepageHeaderText();
        String expectedCheckoutCompletePageText = "CHECKOUT: COMPLETE!";
        Assert.assertEquals(actualCheckoutCompletePageText, expectedCheckoutCompletePageText);
        LOG.info("Checkout complete page validation success");

        //validate thank you message displayed and go back to homepage url

        checkoutCompletePage.validateThanksMessage();
        checkoutCompletePage.goBackToHomePage();
        LOG.info("Validate thanks message and click back to home button success: purchase success");

        //validate home page landing
        String actualBackToHomepageText = homePage.validateHomepageHeaderText();
        String expectedBackToHomepageText = "PRODUCTS";
        Assert.assertEquals(actualBackToHomepageText, expectedBackToHomepageText);
        LOG.info("Back to homepage success");
    }


    @Test
    public void purchaseItemWithoutProvidingUserInfo() {
        //validate the current URL
        homePage = new HomePage(driver);

        homePage.loginToWeb();
        String actualCurrentHeaderTitle = homePage.validateHomepageHeaderText();
        String expectedCurrentHeaderTitle = "PRODUCTS";
        LOG.info("actual home page URL: " + actualCurrentHeaderTitle);
        Assert.assertEquals(actualCurrentHeaderTitle, expectedCurrentHeaderTitle);
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

        YourCartPage yourCartPage = new YourCartPage(driver);

        String actualCartPageText= yourCartPage.validateYourCartPageHeaderText();
        String expectedCartPageText="YOUR CART";
        Assert.assertEquals(actualCartPageText,expectedCartPageText);
        LOG.info("Landed on Your cart page");


        yourCartPage.itemPresentInCart();
        LOG.info("Item was added to cart and is displayed");

        yourCartPage.clickCheckoutButton();
        LOG.info("Checkout button click success");

        //Validate landing to Your Information page
        YourInfoPage infoPage = new YourInfoPage(driver);
        String currentInfoPageText = infoPage.validateInfoPageHeaderText();
        String expectedInfoPageText = "CHECKOUT: YOUR INFORMATION";
        Assert.assertEquals(currentInfoPageText, expectedInfoPageText);
        LOG.info("Landed on Your Information page success");

        //user tries to click continue without providing information

        infoPage.clickContinue();
        LOG.info("User does not provide info and click continue success");
        String error = infoPage.continueWithoutInfo();
        LOG.info("user gets a error message");

        //validate error message
        Assert.assertEquals(error, "Error: First Name is required");
        LOG.info("error message validation success");
    }

@Test
    public void ifUserIsAbleToContinueWithPurchaseWithoutAnItemInCart(){
        homePage =new HomePage(driver);
        homePage.loginToWeb();
        String actualHomePageHeader=homePage.validateHomepageHeaderText();
        Assert.assertEquals(actualHomePageHeader,"PRODUCTS");
        LOG.info("Land on homepage validation success");
        homePage.cartIcon.click();
        LOG.info("Cart icon was clicked");
        YourCartPage cartPage=new YourCartPage(driver);
        String currentPageHeader=cartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(currentPageHeader, "YOUR CART");
        LOG.info("Land on cart page success");
        int numOfItemsInCart=driver.findElements(By.xpath("//div[@class='cart_list']")).size();
         System.out.println(numOfItemsInCart);
        Assert.assertNotEquals(numOfItemsInCart, 2) ;
        LOG.info("No items are added to cart validation success");
        cartPage.clickCheckoutButton();
        YourInfoPage infoPage= new YourInfoPage(driver);
        String actualPageAfterClick=infoPage.validateInfoPageHeaderText();
        Assert.assertEquals(actualPageAfterClick, "Error: Please add a item to cart before checkout");
        LOG.info("Click checkout without putting an item in cart error message validation fail");

    }
}
