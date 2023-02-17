package com.saucedemo.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsBikeLightPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(SauceLabsBikeLightPage.class.getName());

    public SauceLabsBikeLightPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    public static WebElement actualItemAddedToCart;
}
