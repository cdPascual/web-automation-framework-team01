package com.saucedemo.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(YourCartPage.class.getName());

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //varify if item is added to cart

    @FindBy(css = "div[class='inventory_item_name']")
    WebElement itemInCart;

    @FindBy(css = "button[class='btn btn_action btn_medium checkout_button']")
    WebElement checkOutButton;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homepageHeaderElement;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    public static WebElement itemInCartQuantity;


    public void itemPresentInCart() {
        itemInCart.isDisplayed();
        LOG.info("Item is present in cart page");
    }

    public void clickCheckoutButton() {
        checkOutButton.click();
        LOG.info("Checkout button clicked");
    }

    public String validateHomepageHeaderText(){
        String text=getWebPageHeaderText(homepageHeaderElement);
        return text;
    }


}
