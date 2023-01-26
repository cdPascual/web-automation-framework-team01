package com.saucedemo;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutCompletePage.class.getName());

    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/h2[text()='THANK YOU FOR YOUR ORDER']")
    WebElement thankYouMessage;
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small']")
    WebElement backToHomeButton;


    public void validateThanksMessage() {
        thankYouMessage.isDisplayed();
        LOG.info("Thank you message is displayed");
    }

    public void goBackToHomePage() {
        backToHomeButton.click();
        LOG.info("Back to home button clicked");
    }

}
