package com.saucedemo.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class YourCartPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(YourCartPage.class.getName());

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //varify if item is added to cart

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuIcon;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
   public static WebElement cartButton;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    WebElement menuIconAllItemsOption;

//    @FindBy(xpath = "//a[@id='about_sidebar_link']")
//    WebElement menuAboutOption;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    WebElement menuResetAppState;

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement aboutOption;

    @FindBy(id = "logout_sidebar_link")
    WebElement selectLogOutButton;

    @FindBy(id = "react-burger-cross-btn")
    WebElement closeMenuButton;


    @FindBy(css = "div[class='inventory_item_name']")
    WebElement itemInCart;

    @FindBy(xpath = "//span[@class='title']")
    WebElement yourCartHeaderElement;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    public static WebElement itemInCartQuantity;

    @FindBy(xpath = "//div[@class='cart_quantity_label']")
    public static WebElement qtyText;

    @FindBy(xpath = "//div[@class='cart_desc_label']")
    public static WebElement descriptionText;

    @FindBy(css = "button[class='btn btn_action btn_medium checkout_button']")
    public static WebElement checkOutButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium']")
    public static WebElement continueShoppingButton;
    @FindBy(xpath = "//div[@class='cart_quantity']")
    public static WebElement itemQuantity;

    @FindBy(xpath = "//div[@class='cart_list']")
    public static WebElement itemContainer;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    public static WebElement actualItemAddedToCart;


    public void itemPresentInCart() {
        itemInCart.isDisplayed();
        LOG.info("Item is present in cart page");
    }

    public void clickCheckoutButton() {
        checkOutButton.click();
        LOG.info("Checkout button clicked");
    }

    public String validateYourCartPageHeaderText() {
        String text = getWebPageHeaderText(yourCartHeaderElement);
        return text;
    }

    public void yourCartPageMenuOptionsCheck() {

        menuIcon.click();
        menuIconAllItemsOption.isDisplayed();
        aboutOption.isDisplayed();
        menuResetAppState.isDisplayed();
        selectLogOutButton.isDisplayed();
        closeMenuButton.click();
        LOG.info("Menu options checked");
    }

    public void yourCartPageQtyAndDescription() {
        qtyText.isDisplayed();
        descriptionText.isDisplayed();
        LOG.info("QTY and DESCRIPTION text sections are displayed");
    }

    public void ifCheckOutButtonIsDisplayed() {
        checkOutButton.isDisplayed();
    }

    public void ifContinueShoppingButtonIsDisplayed() {
        continueShoppingButton.isDisplayed();
    }

    public void ifCartIconIsDisplayed(){
        cartButton.isDisplayed();
    }




    public String currentItemQuantity(){
    String numOfItem=itemQuantity.getText();
    return numOfItem;
    }




}
