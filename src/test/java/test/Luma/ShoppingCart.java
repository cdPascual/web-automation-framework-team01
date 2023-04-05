package test.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Luma.*;
import utility.Utility;

public class ShoppingCart extends CommonAPI {

    Logger LOG = LogManager.getLogger(ShoppingCart.class.getName());


    @Test
    public void PlaceOneItemInCart() throws InterruptedException {
        Base base = new Base(getDriver());
        HomePage homePage = new HomePage(getDriver());
        WhatsNewPage whatsNewPage= new WhatsNewPage(getDriver());
        WomenHoodieSweatshirtPage womanHoodieSweatshirtPage = new WomenHoodieSweatshirtPage(getDriver());

        homePage.clickOnWhatsNewMenuItem();
        String whatsNewPageTitle = getCurrentTitle();
        Assert.assertEquals(whatsNewPageTitle, "What's New");
        LOG.info("Whats New page validation success");

        whatsNewPage.clickOnWomenHoodiesSweatshirt();
        String WomenHoodieSweatPageTitle = getCurrentTitle();
        Assert.assertEquals(WomenHoodieSweatPageTitle, "Hoodies & Sweatshirts - Tops - Women");
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
        LOG.info(totalItemsInCart+" item/items in the cart.");

        //Assert.assertEquals(cartPageTitle,"Circe Hooded Ice Fleece Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }

    @Test
    public void placeMultipleItemsInCart() throws InterruptedException {
        Base base = new Base(getDriver());
        BagsPage bagsPage=new BagsPage(getDriver());
        WatchesPage watchesPage=new WatchesPage(getDriver());

        base.clickOnBags(getDriver());
        String bagsPageTitle = getCurrentTitle();
        Assert.assertEquals(bagsPageTitle, "Bags - Gear");
        LOG.info("Bags page validation success");

        bagsPage.addMessengerBagToCart(getDriver());

        base.clickOnWatches(getDriver());
        watchesPage.addClamberWatchToCart(getDriver());
        String watchesPageTitle = getCurrentTitle();
        Assert.assertEquals(watchesPageTitle, "Watches - Gear");
        LOG.info("Watches page validation success");

        watchesPage.addClamberWatchToCart(getDriver());

        int totalItemsInCart = base.getTotalItemsInCart(getDriver());
        Assert.assertEquals(totalItemsInCart, 2);
        LOG.info("Add 2 items to cart success. "+totalItemsInCart+" item/items in the cart.");
        LOG.info(totalItemsInCart+" item/items in the cart.");

    }

    @Test
    public void updateItemsInCart() throws InterruptedException {
        Base base = new Base(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        FitnessEquipmentPage fitnessEquipmentPage =new FitnessEquipmentPage(getDriver());

        base.clickOnFitnessEquipment(getDriver());
        String fitnessEquipmentPageTitle = getCurrentTitle();
        Assert.assertEquals(fitnessEquipmentPageTitle, "Fitness Equipment - Gear");
        LOG.info("Fitness Equipment page validation success");

        fitnessEquipmentPage.addSpriteFoamRollerToCart(getDriver());
        int totalItemsInCart = base.getTotalItemsInCart(getDriver());
        Assert.assertEquals(totalItemsInCart, 1);
        LOG.info("Foam Roller added to cart");

        base.clickOnCartIcon();
        base.clickOnViewEditCart();
        String cartPageTitle = getCurrentTitle();
        Assert.assertEquals(cartPageTitle,"Shopping Cart");

        cartPage.updateCart("2");
        String cartQty = cartPage.getTotalPrice();
        Assert.assertEquals(cartQty,"$38.00");
        LOG.info("Cart updated successfully");

    }

    @Test
    public void deleteItemsInCart() throws InterruptedException {
        Base base = new Base(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        FitnessEquipmentPage fitnessEquipmentPage =new FitnessEquipmentPage(getDriver());

        base.clickOnFitnessEquipment(getDriver());
        String fitnessEquipmentPageTitle = getCurrentTitle();
        Assert.assertEquals(fitnessEquipmentPageTitle, "Fitness Equipment - Gear");
        LOG.info("Fitness Equipment page validation success");

        fitnessEquipmentPage.addSpriteFoamRollerToCart(getDriver());
        int totalItemsInCart = base.getTotalItemsInCart(getDriver());
        Assert.assertEquals(totalItemsInCart, 1);
        LOG.info("Foam Roller added to cart");

        base.clickOnCartIcon();
        base.clickOnViewEditCart();
        String cartPageTitle = getCurrentTitle();
        Assert.assertEquals(cartPageTitle,"Shopping Cart");
        LOG.info("Landed on Cart Page");

        cartPage.clickOnDeleteIcon();
        String cartEmpty = cartPage.cartIsEmpty();
        Assert.assertEquals(cartEmpty, "You have no items in your shopping cart.");
        LOG.info("Successfully deleted item/items from cart");
    }



}
