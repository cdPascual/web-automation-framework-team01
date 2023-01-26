package com.saucedemo;

import base.CommonAPI;
import com.mysql.cj.log.Log;
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

    public void ifItemAndPriceDisplayed() {
        itemDisplayed.isDisplayed();
        itemTotalPriceDisplayed.isDisplayed();
        LOG.info("Correct item and price is displayed");
    }

    public void clickFinish() {
        finishButton.click();
        LOG.info("Finish button clicked");
    }


}
