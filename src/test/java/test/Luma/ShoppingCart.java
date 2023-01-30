package test.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Luma.*;
import utility.Utility;

public class ShoppingCart extends CommonAPI {

    Logger LOG = LogManager.getLogger(Account.class.getName());


    @Test
    public void PlaceOneItemInCart() throws InterruptedException {
        Base base = new Base(getDriver());
        HomePage homePage = new HomePage(getDriver());
        WhatsNewPage whatsNewPage= new WhatsNewPage(getDriver());
        WomenHoodieSweatshirtPage womanHoodieSweatshirtPage = new WomenHoodieSweatshirtPage(getDriver());

        homePage.clickOnWhatsNewMenuItem();
        String whatsNewPageTitle = getCurrentTitle();
        Assert.assertEquals(whatsNewPageTitle, "What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Whats New page validation success");

        whatsNewPage.clickOnWomenHoodiesSweatshirt();
        String WomenHoodieSweatPageTitle = getCurrentTitle();
        Assert.assertEquals(WomenHoodieSweatPageTitle, "Hoodies & Sweatshirts - Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Women's Hoodie & Sweatshirt page validation success");

        womanHoodieSweatshirtPage.clickOnMediumSize();
        Assert.assertEquals(womanHoodieSweatshirtPage.getSizeStatus(),true);
        LOG.info("click on medium success");

        womanHoodieSweatshirtPage.clickOnGreenColor();
        Assert.assertEquals(womanHoodieSweatshirtPage.getColorStatus(),true);
        LOG.info("click on green success");

        womanHoodieSweatshirtPage.clickAddToCart(getDriver());
        int totalItemsInCart = base.getTotalItemsInCart(getDriver());
        Assert.assertEquals(totalItemsInCart, 1);
        LOG.info("Add one item to cart success");
        LOG.info("There "+ totalItemsInCart+" item/items in the cart.");

        //Assert.assertEquals(cartPageTitle,"Circe Hooded Ice Fleece Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }

    @Test
    public void placeMultipleItemsInCart() throws InterruptedException {
        Base base = new Base(getDriver());
        HomePage homePage = new HomePage(getDriver());
        WhatsNewPage whatsNewPage= new WhatsNewPage(getDriver());
        WomenHoodieSweatshirtPage womanHoodieSweatshirtPage = new WomenHoodieSweatshirtPage(getDriver());

        homePage.clickOnWhatsNewMenuItem();
        String whatsNewPageTitle = getCurrentTitle();
        Assert.assertEquals(whatsNewPageTitle, "What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Whats New page validation success");

        whatsNewPage.clickOnWomenHoodiesSweatshirt();
        String WomenHoodieSweatPageTitle = getCurrentTitle();
        Assert.assertEquals(WomenHoodieSweatPageTitle, "Hoodies & Sweatshirts - Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Women's Hoodie & Sweatshirt page validation success");

        womanHoodieSweatshirtPage.clickOnMediumSize();
        Assert.assertEquals(womanHoodieSweatshirtPage.getSizeStatus(),true);
        LOG.info("click on medium success");

        womanHoodieSweatshirtPage.clickOnGreenColor();
        Assert.assertEquals(womanHoodieSweatshirtPage.getColorStatus(),true);
        LOG.info("click on green success");

        womanHoodieSweatshirtPage.clickAddToCart(getDriver());
        int totalItemsInCart = base.getTotalItemsInCart(getDriver());
        Assert.assertEquals(totalItemsInCart, 1);
        LOG.info("Add one item to cart success");
        LOG.info("There "+ totalItemsInCart+" item/items in the cart.");

        //Assert.assertEquals(cartPageTitle,"Circe Hooded Ice Fleece Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }

    public void updateItemsInCart(){
    }

    public void deleteItemsInCart(){
    }




}
