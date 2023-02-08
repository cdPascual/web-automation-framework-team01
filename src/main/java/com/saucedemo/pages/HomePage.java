package com.saucedemo.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utility;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String username = Utility.getProperties().getProperty("saucedemo.correct.username");
    public String password = Utility.getProperties().getProperty("saucedemo.correct.password");

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


    @FindBy(xpath = "//span[@class='title']")
    WebElement pageHeaderTitle;

    @FindBy(xpath = "//div[@class='primary_header']")
    WebElement primaryHeader;

    @FindBy(xpath = "//div[@class='header_secondary_container']")
    WebElement secondaryHeader;
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuIcon;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    public static WebElement cartIcon;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public static WebElement productContainerIcon;

    @FindBy(xpath = "//div[@class='header_label']/div")
    WebElement appLogo;

    @FindBy(xpath = "//footer[@class='footer']")
    WebElement footer;

    @FindBy(xpath = "//li[@class='social_twitter']")
    WebElement twitterSocialLink;

    @FindBy(xpath = "//li[@class='social_facebook']")
    WebElement facebookSocialLink;

    @FindBy(xpath = "//li[@class='social_linkedin']")
    WebElement linkedinSocialLink;

    @FindBy(xpath = "//div[@class='footer_copy']")
    public static WebElement privacyPolicyText;
    @FindBy(xpath = "//img[@alt='Swag Bot Footer']")
    WebElement footerBotImage;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homepageHeaderElement;

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]")
    WebElement homePageItem1;

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]")
    WebElement homePageItem2;

    @FindBy(xpath = "//div[@class='inventory_list']/div[3]")
    WebElement homePageItem3;

    @FindBy(xpath = "//div[@class='inventory_list']/div[4]")
    WebElement homePageItem4;

    @FindBy(xpath = "//div[@class='inventory_list']/div[5]")
    WebElement homePageItem5;

    @FindBy(xpath = "//div[@class='inventory_list']/div[6]")
    WebElement homePageItem6;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    WebElement menuIconAllItemsOption;

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement menuAboutOption;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    WebElement menuResetAppState;

    @FindBy(xpath = "//div[@class='nav-image']/a")
    WebElement aboutPageOption;

    @FindBy(id = "logout_sidebar_link")
     WebElement selectLogOutButton;

    @FindBy(xpath = "//div[@class='inventory_list']/div[2]")
    WebElement sauceLabsBikeLightItem;

    @FindBy(xpath = "//div[@class='inventory_list']/div[2]/div/a/img")
    WebElement sauceLabsBikeLightImg;

    @FindBy(xpath = "//div[@class='inventory_list']/div[2]/div/a")
    WebElement sauceLabsBikeLightImgLink;

    @FindBy(xpath = "//a[@id='item_0_title_link']")
    public static WebElement sauceLabsBikeLightTitleLink;

    @FindBy(xpath = "//a[@id='item_0_title_link']/div")
    public static WebElement sauceLabsBikeLightTitle;


    @FindBy(xpath = "//*[@id='inventory_container']/div/div[2]/div[2]/div[1]/div")
    public static WebElement sauceLabsBikeLightDescription;

    @FindBy(xpath = "//*[@id='inventory_container']/div/div[2]/div[2]/div[2]/div")
    public static WebElement sauceLabsBikeLightPrice;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    public
    WebElement sauceLabsBikeLightAddToCartIcon;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public static WebElement addToCartButtonOnSauceLabsBackPack;

    @FindBy(id = "react-burger-cross-btn")
    WebElement closeMenuButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']/span")
    public static WebElement itemQuantityPresentInCart;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    public static WebElement sauceLabsBackpackRemoveButton;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    public static WebElement sauceLabsBikeLightRemoveButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public static WebElement itemQuantityInCart;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[1]")
    WebElement firstFilterOption;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[2]")
    WebElement secondFilterOption;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[3]")
    WebElement thirdFilterOption;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[4]")
    WebElement fourthFilterOption;

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
        menuIcon.click();
        selectLogOutButton.click();
        LOG.info("Clicked on options icon and clicked on log out");
    }

//public String getPageHeaderTitle(){
//        return driver.
//}


    public void pageHeader() {
        loginToWeb();
        primaryHeader.isDisplayed();
        LOG.info("Primary header is displayed");
        secondaryHeader.isDisplayed();
        LOG.info("Secondary header is displayed");
        pageHeaderTitle.isDisplayed();
        appLogo.isDisplayed();
        LOG.info("App logo is displayed");
        menuIcon.isDisplayed();
        LOG.info("Menu icon is displayed");
        cartIcon.isDisplayed();
        LOG.info("Cart icon is displayed");
        productContainerIcon.isDisplayed();
        LOG.info("Product container icon is displayed");
        footer.isDisplayed();
        LOG.info("footer is displayed");
        twitterSocialLink.isDisplayed();
        facebookSocialLink.isDisplayed();
        linkedinSocialLink.isDisplayed();
        LOG.info("All social media links are displayed");
        privacyPolicyText.isDisplayed();
        LOG.info("All privacy policy texts are displayed");
        footerBotImage.isDisplayed();
        LOG.info("Bot image is displayed");


    }


    public String validateHomepageHeaderText() {
        String text = getWebPageHeaderText(homepageHeaderElement);
        return text;
    }


    public void validateClickOnAllItemsOptionOnSideMenu() {
        menuIcon.click();
        LOG.info("clicked on menu icon on homepage");
        menuIconAllItemsOption.click();
        LOG.info("clicked on first option 'All Items' ");
        homePageItem1.isDisplayed();
        homePageItem2.isDisplayed();
        homePageItem3.isDisplayed();
        homePageItem4.isDisplayed();
        homePageItem5.isDisplayed();
        homePageItem6.isDisplayed();
        LOG.info("All items are displayed on the homepage after clicking option to show all items");
    }

    public void resetAppPageOptionOnMenu() {
        menuIcon.click();
       menuResetAppState.isEnabled();
        LOG.info("Reset App State button checked");
    }

    public void validateClickOnLogOutOptionOnMenu() {
        selectLogOutButton.click();
        LOG.info("Logout button clicked");

    }


    public void validateCLickOnAboutOptionOnSideMenu() {
        menuAboutOption.click();
        aboutPageOption.isDisplayed();
        LOG.info("About page validation complete");

    }


    public void sauceLabsBikeLightItemValidation() {
        loginToWeb();
        sauceLabsBikeLightItem.isDisplayed();
        LOG.info("Sauce Labs Bike Light is displayed on home page");
        sauceLabsBikeLightImg.isDisplayed();
        LOG.info("Sauce Labs Bike Light image is displayed");
        sauceLabsBikeLightImgLink.isEnabled();
        LOG.info("Sauce Labs Bike Light image is enabled to click");
//        sauceLabsBikeLightTitle.getText().substring(1, 17);
//        LOG.info("Sauce Labs Bike Light Title is displayed");
        sauceLabsBikeLightTitleLink.isEnabled();
        LOG.info("Sauce Labs Bike Light title link is enabled for click");
//        sauceLabsBikeLightDescription.getText().substring(1, 159);
//        LOG.info("Sauce Labs Bike Light discription is displayed");
//        sauceLabsBikeLightPrice.getText().substring(5, 8);
//        LOG.info("Sauce Labs Bike Light price is displayed");
        sauceLabsBikeLightAddToCartIcon.isDisplayed();
        LOG.info("Add to cart icon is displayed");
        sauceLabsBikeLightAddToCartIcon.isEnabled();
        LOG.info("Add to cart icon is enabled for click");
    }


    public void addFirst2ItemsToCart() {
        loginToWeb();
        sauceLabsBikeLightAddToCartIcon.click();
        addToCartButtonOnSauceLabsBackPack.click();
        LOG.info("Two items are added to cart");
    }

    public void afterAddingItemsToCartCheckResetAppStateFunction() {
        menuIcon.click();
        menuResetAppState.click();
        closeMenuButton.click();
        LOG.info("Reset app state has been clicked");
    }

//    public void filterOptionNameAtoZ(){
//        loginToWeb();
//        productContainerIcon.click();
//      firstFilterOption.click();
//      LOG.info("Logged in to web, clicked product container, clicked on first filter option");
//    }



//    public void g(){
//        driver.findElement(By.xpath("//div[@class='inventory_list']")).
//    }


    public void checkIfTwitterIconsWork(){
        twitterSocialLink.click();
        LOG.info("Twitter icon clicked");
    }

    public void checkIfFaceBookIconWork(){
        facebookSocialLink.click();
    }

    public void checkIfLinkdenIconWok(){
        linkedinSocialLink.click();
    }

}


