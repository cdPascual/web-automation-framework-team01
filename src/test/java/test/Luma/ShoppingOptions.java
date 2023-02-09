package test.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Luma.Base;
import pages.Luma.WatchesPage;

public class ShoppingOptions extends CommonAPI {
    Logger LOG = LogManager.getLogger(ShoppingOptions.class.getName());

    public void selectWomensTopColor(){
        Base base = new Base(getDriver());


        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnWomen();
        String womenPage = getCurrentTitle();
        Assert.assertEquals(womenPage,"Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites" );

        base.clickOnWomenTops(getDriver());
        String womenTopsPage = getCurrentTitle();
        Assert.assertEquals(womenTopsPage,"Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");


    }
    public void selectMensTopSize(){

    }
    @Test
    public void selectSortByPrice() throws InterruptedException {
        Base base = new Base(getDriver());
        WatchesPage watchesPage = new WatchesPage(getDriver());

        base.clickOnWatches(getDriver());

        watchesPage.sortByPrice();

        Thread.sleep(3000);

        double firstItemPrice = Double.parseDouble(watchesPage.getTextFromFirstItem(getDriver()));
        LOG.info(firstItemPrice+" is the price of the first item");

        double lastItemPrice = Double.parseDouble(watchesPage.getTextFromLastItem(getDriver()));
        LOG.info(lastItemPrice+" is the price of the last item");
        boolean ascendingOrder = firstItemPrice<lastItemPrice;

        Assert.assertEquals(ascendingOrder,true);
        LOG.info("Sort by price successful. first item is "+firstItemPrice+" last item is "+lastItemPrice);


    }
}
