package com.saucedemo.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utility;

public class YourInfoPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(YourCartPage.class.getName());

    public YourInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement userFirstnameBox;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement userLastnameBox;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipPostalBox;

    @FindBy(xpath = "//input[@class='submit-button btn btn_primary cart_button btn_action']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    WebElement errorMessage;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homepageHeaderElement;


    public String userInfoFirstname = Utility.getProperties().getProperty("UserInfoFirstname");
    public String userInfoLastname = Utility.getProperties().getProperty("UserInfoLastname");
    public String userInfoZip = Utility.getProperties().getProperty("UserInfoZip");


    public void enterUserInfo() {
        userFirstnameBox.sendKeys(userInfoFirstname);
        userLastnameBox.sendKeys(userInfoLastname);
        LOG.info("User info entered");
    }

    public void clickContinue() {
        zipPostalBox.sendKeys(userInfoZip);
        continueButton.click();
        LOG.info(" continue button clicked");
    }

    public String continueWithoutInfo() {
        return errorMessage.getText();

    }

    public String validateHomepageHeaderText(){
        String text=getWebPageHeaderText(homepageHeaderElement);
        return text;
    }



}
