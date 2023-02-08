package test.saucedemotests;

import base.CommonAPI;
import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.YourCartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePageTest.class.getName());

    HomePage homepage;

    @Test
    public void checkLogoutFunctionality() {
        homepage = new HomePage(driver);
        homepage.logOut();
        LOG.info("Log out from website successful");

        //Validate landing back on login page
        String actualLoginPageUrl = getCurrentUrl();
        String expectedLoginPageUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl);
        LOG.info("Back to login page validation success");
    }

    @Test
    public void validateHeaderFooterElementsDisplayed() {
        homepage = new HomePage(driver);
        homepage.pageHeader();
    }

    @Test
    public void validateAllOptionsOnSideMenu() {
        homepage = new HomePage(driver);
        homepage.loginToWeb();
        homepage.validateClickOnAllItemsOptionOnSideMenu();
        LOG.info("All Items are visible on the home page after the click success");
        homepage.validateClickOnLogOutOptionOnMenu();
        String currentUrl = getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(currentUrl, expectedUrl);
        LOG.info("Click on log out option and url validation success");
        homepage.loginToWeb();
        String actualHomepageHeaderText = homepage.validateHomepageHeaderText();
        String expectedHomePageHeaderText = "PRODUCTS";
        Assert.assertEquals(expectedHomePageHeaderText, expectedHomePageHeaderText);
        LOG.info("Log back in to website validation success");
        LOG.info("Logged back to website success");
        homepage.resetAppPageOptionOnMenu();
        LOG.info("Reset option check success");
        homepage.validateCLickOnAboutOptionOnSideMenu();
        LOG.info("Click on about option and about page landing success");

    }

    @Test
    public void validateSauceLabsLightItem() {
        homepage = new HomePage(driver);
        homepage.sauceLabsBikeLightItemValidation();
        homepage.sauceLabsBikeLightTitle.isDisplayed();
        String actualItemText = homepage.sauceLabsBikeLightTitle.getText().substring(0, 21);
        String expectedItemText = "Sauce Labs Bike Light";
        Assert.assertEquals(actualItemText, expectedItemText);
        LOG.info("Item Title is displayed and text validation success");
        homepage.sauceLabsBikeLightDescription.isDisplayed();
        String actualItemDescription = homepage.sauceLabsBikeLightDescription.getText().substring(0, 159);
        String expectedItemDescription = "A red light isn't the desired state in testing but it sure helps when riding " +
                "your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        LOG.info("Item description is displayed and text validation success.");
        homepage.sauceLabsBikeLightPrice.isDisplayed();
        String actualItemPrice = homepage.sauceLabsBikeLightPrice.getText().substring(1, 5);
        String expectedItemPrice = "9.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
        LOG.info("Item price is displayed and text validation success");


    }

    @Test
    public void checkResetAppStateFunctionality() {
        homepage = new HomePage(driver);
        homepage.addFirst2ItemsToCart();
        LOG.info("Add 2 items to cart success");
        String actualQuantityOfItemsAddedToCart = homepage.itemQuantityPresentInCart.getText();
        String expectedQuantityOfItemsShouldBePreset = "2";
        Assert.assertEquals(actualQuantityOfItemsAddedToCart, expectedQuantityOfItemsShouldBePreset);
        LOG.info("Current cart quantity validation success");
        homepage.afterAddingItemsToCartCheckResetAppStateFunction();
        LOG.info("Click reset app state and close menu success");
        int actualQuantityOfItemsPresentInCartAfterResetButtonClick = driver.findElements(By.xpath("//span[@class='shopping_cart_badge']")).size();
        Assert.assertEquals(actualQuantityOfItemsPresentInCartAfterResetButtonClick, 0);
        LOG.info("After clicking reset app state, no items were left in cart validation success");
        String actualCurrentOptionPresentOnFirstItem = homepage.sauceLabsBackpackRemoveButton.getText();
        String expectedCurrentOptionPresentOnFirstItem = "REMOVE";
        Assert.assertEquals(actualCurrentOptionPresentOnFirstItem, expectedCurrentOptionPresentOnFirstItem);
        LOG.info("Add to cart button on first item is displayed validation success");
        String actualCurrentOptionPresentOnSecondItem = homepage.sauceLabsBikeLightRemoveButton.getText();
        String expectedCurrentOptionPresentOnSecondItem = "REMOVE";
        Assert.assertEquals(actualCurrentOptionPresentOnSecondItem, expectedCurrentOptionPresentOnSecondItem);
        LOG.info("Add to cart button on second item is displayed validation success");

    }


    List<WebElement> filterOptionsList;
    Select objSelect;
    List<WebElement> elementList;

    @FindBy(xpath = "//div[@class='inventory_item']")
    WebElement itemContainer;

    @Test
    public void nameAndNumOfFilterOptionsValidation() {
        HomePage homepage = new HomePage(driver);
        homepage.loginToWeb();
        //String[] exp= {"Name (A to Z)", "Name (Z to A)","Price (low to high)","Price (high to low)"};
        objSelect = new Select(homepage.productContainerIcon);
        filterOptionsList = new ArrayList<WebElement>();
        filterOptionsList = objSelect.getOptions();
        LOG.info("Number of options in filter");

        int actualNumOfItemsInFilter = filterOptionsList.size();
        Assert.assertEquals(actualNumOfItemsInFilter, 4);
        LOG.info("NUmber of options in filter validation success");

        String options;
        LOG.info("Options in filter are: ");
        for (int i = 0; i < filterOptionsList.size(); i++) {
            options = filterOptionsList.get(i).getText();
            System.out.println(options);
        }


//         //homepage.productContainerIcon.click();
//        Select select= new Select(homepage.productContainerIcon);
//        select.selectByIndex(1);
//        LOG.info("First filter selected");
//
//        ArrayList<String> obtainedList = new ArrayList<>();
//        elementList= (List<WebElement>) itemContainer;
//        for(WebElement we:elementList){
//            obtainedList.add(we.getText());
//        }
//        ArrayList<String> sortedList = new ArrayList<>();
//        for(String s:obtainedList){
//            sortedList.add(s);
//        }
//        Collections.sort(sortedList);
//        Assert.assertTrue(sortedList.equals(obtainedList));

LOG.info("Items sorted Z-A validation success");

    }

//     @Test
//    public void validateAllFilterOptions(){
//            homepage=new HomePage(driver);
//            homepage.filterOptionNameAtoZ();
//            //Assert.
//        }


    @Test
    public void checkIfAllImagesAreUnique(){
        homepage =new HomePage(driver);
        homepage.loginToWebUsingProbCredentials();
        int actualNumOfTheSameElement=driver.findElements(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']")).size();
        Assert.assertEquals(actualNumOfTheSameElement, 1);
    }


    @Test
    public void validateClickOnTwitterIcons(){
        homepage= new HomePage(driver);
        homepage.loginToWeb();
        homepage.checkIfTwitterIconsWork();
        LOG.info("Twitter icon click success");
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String actualTwitterWebpage= getCurrentUrl();
        Assert.assertEquals(actualTwitterWebpage, "https://twitter.com/saucelabs");
        LOG.info("Twitter page landing validation success");
    }

    @Test
    public void validateClickOnFacebookIcon(){
        homepage=new HomePage(driver);
        homepage.loginToWeb();
        homepage.checkIfFaceBookIconWork();
        LOG.info("Facebook icon click success");
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String actualFacebookWebpage= getCurrentUrl();
        Assert.assertEquals(actualFacebookWebpage, "https://www.facebook.com/saucelabs");
        LOG.info("Facebook page landing validation success");
    }

    @Test
    public void validateClickOnLinkdenIcon(){
        homepage = new HomePage(driver);
        homepage.loginToWeb();
        homepage.checkIfLinkdenIconWok();
        LOG.info("Linkeden icon click success");
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String actualLinkdenWebpageTitle= getCurrentTitle();
        Assert.assertEquals(actualLinkdenWebpageTitle, "Sauce Labs | LinkedIn");
        LOG.info("Linkeden page landing validation success");
    }

    @Test
    public void userClicksSpecificItemValidation(){
        homepage= new HomePage(driver);
        homepage.selectItemInProbAcc();
        LOG.info("Logged in to problem user and clicked on item");

        String currentPageUrl= getCurrentUrl();
        Assert.assertEquals(currentPageUrl, "https://www.saucedemo.com/inventory-item.html?id=5");
        LOG.info("Cart page landing validation success");

        homepage.addItemToCartInProbAcc();
        int actualQuantityOfItemsPresentInCart = driver.findElements(By.xpath("//span[@class='shopping_cart_badge']")).size();
        Assert.assertEquals(actualQuantityOfItemsPresentInCart, 1);
        LOG.info("Item added to cart validation failed");

    }

}
