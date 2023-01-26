package com.saucedemo;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsBackpackPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(SauceLabsBackpackPage.class.getName());

    public SauceLabsBackpackPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;


    public void clickAddToCart() {
        addToCartButton.click();
        LOG.info("Add to cart button clicked");
    }

    public void clickOnCart() {
        cartIcon.click();
        LOG.info("Cart icon clicked");
    }


}
