package test.saucedemotests;

import base.CommonAPI;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.YourCartPage;
import com.saucedemo.pages.YourInfoPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YourCartPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(YourCartPageTest.class.getName());

    YourCartPage yourCartPage;
    HomePage homepage;

    YourInfoPage yourInfoPage;

    @Test
    public void validateElementsPresentOnYourCartPage(){
        homepage=new HomePage(driver);
        homepage.loginToWeb();
        LOG.info("Logged in to web");
        String actualHomePageHeaderText=homepage.validateHomepageHeaderText();
        Assert.assertEquals(actualHomePageHeaderText, "PRODUCTS");
        LOG.info("Product page assertion success");
        homepage.cartIcon.click();
        LOG.info("cart icon click success");
        yourCartPage=new YourCartPage(driver);
        String actualYourCartPageHeaderText= yourCartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(actualYourCartPageHeaderText, "YOUR CART");
        LOG.info("your cart Page assertion success");
        yourCartPage.ifCartIconIsDisplayed();
        LOG.info("Cart Icon present validation success");
        yourCartPage.yourCartPageQtyAndDescription();
        LOG.info("QTY and DESCRIPTION is displayed validation success");
        String actualQtyText= yourCartPage.qtyText.getText();
        Assert.assertEquals(actualQtyText, "QTY");
        LOG.info("QTY text validation success");
        String actualDescriptionText=yourCartPage.descriptionText.getText();
        Assert.assertEquals(actualDescriptionText,"DESCRIPTION");
        LOG.info("DESCRIPTION Text validation success");
        yourCartPage.yourCartPageMenuOptionsCheck();
        LOG.info("all menu options validation success");
        yourCartPage.ifCheckOutButtonIsDisplayed();
        LOG.info("Validate if checkout button is displayed success");
        yourCartPage.checkOutButton.click();
        yourInfoPage=new YourInfoPage(driver);
        String actualYOurInfoPageHeaderText=yourInfoPage.validateInfoPageHeaderText();
        Assert.assertEquals(actualYOurInfoPageHeaderText, "CHECKOUT: YOUR INFORMATION");
        LOG.info("Your info page assertion complete");
        yourInfoPage.cancelButton.click();
        String backToCartPageVal=yourCartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(backToCartPageVal, "YOUR CART");
        yourCartPage.ifContinueShoppingButtonIsDisplayed();
        LOG.info("Validate if continue shopping button is displayed success");
        YourCartPage.continueShoppingButton.click();
        String actualHomepageHeaderTitle=homepage.validateHomepageHeaderText();
        Assert.assertEquals(actualHomepageHeaderTitle, "PRODUCTS");
        LOG.info("after click, product page landing validation success");
    }

    @Test
    public void checkIfUserIsAbleToChangeItemQuantityInCartPage(){
        homepage=new HomePage(driver);
        homepage.loginToWeb();
        homepage.sauceLabsBikeLightAddToCartIcon.click();
        LOG.info("One item was added to cart");
        homepage.cartIcon.click();
        yourCartPage= new YourCartPage(driver);
        String currentPage=yourCartPage.validateYourCartPageHeaderText();
        Assert.assertEquals(currentPage, "YOUR CART");
        LOG.info("Cart page landing success");
        String currentNumOfItems=yourCartPage.currentItemQuantity();
        Assert.assertEquals(currentNumOfItems, "1");
        LOG.info("Num of items in cart validation success");
        String ifElementIsAnInputField=yourCartPage.itemQuantity.getTagName();
        Assert.assertNotEquals(ifElementIsAnInputField, "input");
        LOG.info("User is unable to change item Quantity in cart page validation success");
    }


}
