package com.saucedemo;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReadFromConfigFile;

public class LoginPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String username = ReadFromConfigFile.getProperties().getProperty("saucedemo.correct.username");
    public String password = ReadFromConfigFile.getProperties().getProperty("saucedemo.correct.password");

    public String incorrectUser = ReadFromConfigFile.getProperties().getProperty("saucedemo.incorrect.username");
    public String incorrectPass = ReadFromConfigFile.getProperties().getProperty("saucedemo.incorrect.password");
    @FindBy(css = "#user-name")
    WebElement userField;
    @FindBy(css = "#password")
    WebElement passField;
    @FindBy(css = "#login-button")
    WebElement submitField;

    @FindBy(xpath = "(//div[@class='error-message-container error'])/h3")
    WebElement errorMessage;

    //correct username and password test
    public void typeUsername() {
        userField.sendKeys(username);
        LOG.info("Enter username success");
    }

    public void typePass() {
        passField.sendKeys(password);
        LOG.info("Enter password success");
    }

    public void clickOnSubmit() {
        submitField.click();
        LOG.info("Submit button click success");
    }


    //incorrect username and correct password test

    public void typeIncorrectUser() {
        userField.sendKeys(incorrectUser);
        LOG.info("Incorrect username entered");
    }

    public void typeIncorrectPass() {
        passField.sendKeys(incorrectPass);
        LOG.info("Incorrect password entered");
    }

    public void clickSubmit() {
        submitField.click();
        LOG.info("Submit button clicked");
    }


    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();

    }


//    @FindBy( xpath= "//input[@id='user_name']")
//   WebElement userField;
//
//    @FindBy(xpath = "//input[@id='password']")
//    WebElement passField;
//
//    @FindBy(xpath = "//input[@id='login_button']")
//    WebElement submitField;

//    public void findWebElement(WebElement element, String text){
//            element.sendKeys(text);
//    }
//
//    public void click(WebElement element) {
//
//        element.click();
//    }

//public void typeUsername(String username){
//    findWebElement(userField, username);
//    LOG.info("Enter username success");
//}
//
//public void typePassword(String password){
//    findWebElement(passField,password);
//    LOG.info("Enter password success");
//}
//
//public void clickOnSubmit(){
//    click(submitField);
//    LOG.info("Submit button click success");
//}

}