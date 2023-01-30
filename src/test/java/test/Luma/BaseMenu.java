package test.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Luma.Base;

import java.io.IOException;

public class BaseMenu extends CommonAPI {
    Logger LOG = LogManager.getLogger(Account.class.getName());

    @Test
    public void headerWhatsNewLink(){
        Base base = new Base(getDriver());


        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnWhatsNew();
        String whatsNewPage = getCurrentTitle();
        Assert.assertEquals(whatsNewPage,"What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

    }

    @Test
    public void headerWomenLinks() throws IOException, InterruptedException {
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

        base.clickOnWomenBottoms(getDriver());
        String womenBottoms = getCurrentTitle();
        Assert.assertEquals(womenBottoms,"Bottoms - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnWomenJackets(getDriver());
        String womenJacketTitle = getCurrentTitle();
        Assert.assertEquals(womenJacketTitle, "Jackets - Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnWomenHoodiesAndSweaters(getDriver());
        String womanHoodiesSweater = getCurrentTitle();
        Assert.assertEquals(womanHoodiesSweater, "Hoodies & Sweatshirts - Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnWomenTees(getDriver());
        String MenTees = getCurrentTitle();
        Assert.assertEquals(MenTees, "Tees - Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnWomenBrasAndTanks(getDriver());
        String MenBrasTank = getCurrentTitle();
        Assert.assertEquals(MenBrasTank,"Bras & Tanks - Tops - Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

    }
    @Test
    public void headerMenLinks() throws IOException, InterruptedException {
        Base base = new Base(getDriver());


        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnMen();
        String menPage = getCurrentTitle();
        Assert.assertEquals(menPage,"Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites" );

        base.clickOnMenTops(getDriver());
        String menTopsPage = getCurrentTitle();
        Assert.assertEquals(menTopsPage,"Tops - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenBottoms(getDriver());
        String menBottoms = getCurrentTitle();
        Assert.assertEquals(menBottoms,"Bottoms - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenJackets(getDriver());
        String menJacketTitle = getCurrentTitle();
        Assert.assertEquals(menJacketTitle, "Jackets - Tops - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenHoodiesAndSweaters(getDriver());
        String menHoodiesSweater = getCurrentTitle();
        Assert.assertEquals(menHoodiesSweater, "Hoodies & Sweatshirts - Tops - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenTees(getDriver());
        String menTees = getCurrentTitle();
        Assert.assertEquals(menTees, "Tees - Tops - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenTanks(getDriver());
        String menTanks = getCurrentTitle();
        Assert.assertEquals(menTanks,"Tanks - Tops - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenPants(getDriver());
        String menPants = getCurrentTitle();
        Assert.assertEquals(menPants,"Pants - Bottoms - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnMenShorts(getDriver());
        String menShorts = getCurrentTitle();
        Assert.assertEquals(menShorts,"Shorts - Bottoms - Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }

    @Test
    public void headerGearLinks() throws InterruptedException {
        Base base = new Base(getDriver());

        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnGear();
        String gearPage = getCurrentTitle();
        Assert.assertEquals(gearPage,"Gear Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnBags(getDriver());
        String bagsPage = getCurrentTitle();
        Assert.assertEquals(bagsPage,"Bags - Gear Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnFitnessEquipment(getDriver());
        String fitnessEquipmentPage = getCurrentTitle();
        Assert.assertEquals(fitnessEquipmentPage,"Fitness Equipment - Gear Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnWatches(getDriver());
        String watchesPage = getCurrentTitle();
        Assert.assertEquals(watchesPage,"Watches - Gear Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

    }

    @Test
    public void headerTrainingLinks(){
        Base base = new Base(getDriver());

        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnTraining();
        String trainingPage = getCurrentTitle();
        Assert.assertEquals(trainingPage,"Training Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

        base.clickOnVideoDownload(getDriver());
        String videoDownloadPage = getCurrentTitle();
        Assert.assertEquals(videoDownloadPage,"Video Download - Training Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");

    }

    @Test
    public void headerSaleLink(){
        Base base = new Base(getDriver());

        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnSale();
        String salePage = getCurrentTitle();
        Assert.assertEquals(salePage,"Sale Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }
}
