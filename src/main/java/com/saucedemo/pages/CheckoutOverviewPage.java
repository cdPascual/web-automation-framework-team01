package com.saucedemo.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutOverviewPage.class.getName());

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@class='btn btn_action btn_medium cart_button']")
    WebElement finishButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement itemDisplayed;

    @FindBy(xpath = "//div[text()='32.39']")
    WebElement itemTotalPriceDisplayed;

    @FindBy(xpath = "//span[@class='title']")
    WebElement overviewPageHeaderElement;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public static WebElement totalForItem;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public static  WebElement totalTax;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    public static WebElement subTotal;


    public void ifItemAndPriceDisplayed() {
        itemDisplayed.isDisplayed();
        itemTotalPriceDisplayed.isDisplayed();
        LOG.info("Correct item and price is displayed");
    }

    public void clickFinish() {
        finishButton.click();
        LOG.info("Finish button clicked");
    }

    public String validateOverviewPageHeaderText(){
        String text=getWebPageHeaderText(overviewPageHeaderElement);
        return text;
    }



}
