package com.saucedemo;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReadFromConfigFile;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String username = ReadFromConfigFile.getProperties().getProperty("saucedemo.correct.username");
    public String password = ReadFromConfigFile.getProperties().getProperty("saucedemo.correct.password");

    @FindBy(id = "item_4_title_link")
    WebElement sauceLabsBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(css = "#user-name")
    WebElement userField;
    @FindBy(css = "#password")
    WebElement passField;
    @FindBy(css = "#login-button")
    WebElement submitField;


    @FindBy(id = "react-burger-menu-btn")
    WebElement optionsIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement selectLogOutButton;


    public void selectItem() {
        sauceLabsBackpack.click();
        LOG.info("Sauce Labs backpack click success");

    }

    public void clickAddToCart() {
        addToCartButton.click();
        LOG.info("Item is added to cart");
    }


    public void loginToWeb() {
        userField.sendKeys(username);
        passField.sendKeys(password);
        submitField.click();
        LOG.info("Logged in to Sauce demo");

    }


    public void logOut() {
        loginToWeb();
        optionsIcon.click();
        selectLogOutButton.click();
        LOG.info("Clicked on options icon and clicked on log out");
    }


}

