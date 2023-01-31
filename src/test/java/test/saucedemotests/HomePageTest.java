package test.saucedemotests;

import base.CommonAPI;
import com.beust.ah.A;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePageTest.class.getName());

    HomePage homepage;

    @Test
    public void checkLogoutFunctionality() {
        homepage = new HomePage(driver);
        homepage.logOut();
        LOG.info("Log out from website successful");

        //Validate landing back on login page
        String actualLoginPageUrl= getCurrentUrl();
        String expectedLoginPageUrl= "https://www.saucedemo.com/";
        Assert.assertEquals(actualLoginPageUrl,expectedLoginPageUrl);
        LOG.info("Back to login page validation success");
    }

    @Test
    public void validateHeaderFooterElementsDisplayed(){
        homepage = new HomePage(driver);
        homepage.pageHeader();
    }

    @Test
    public void validateAllOptionsOnSideMenu(){
        homepage= new HomePage(driver);
        homepage.loginToWeb();
        homepage.validateClickOnAllItemsOptionOnSideMenu();
        LOG.info("All Items are visible on the home page after the click success");
        homepage.validateClickOnLogOutOptionOnMenu();
        String currentUrl= getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/";
        Assert.assertEquals(currentUrl,expectedUrl);
        LOG.info("Click on log out option and url validation success");
        homepage.loginToWeb();
        String actualHomepageHeaderText= homepage.validateHomepageHeaderText();
        String expectedHomePageHeaderText= "PRODUCTS";
        Assert.assertEquals(expectedHomePageHeaderText,expectedHomePageHeaderText);
        LOG.info("Log back in to website validation success");
        LOG.info("Logged back to website success");
        homepage.resetAppPageOptionOnMenu();
        LOG.info("Reset option check success");
        homepage.validateCLickOnAboutOptionOnSideMenu();
        LOG.info("Click on about option and about page landing success");

    }

    @Test
    public  void validateSauceLabsLightItem(){
        homepage= new HomePage(driver);
        homepage.sauceLabsBikeLightItemValidation();
        homepage.sauceLabsBikeLightTitle.isDisplayed();
        String actualItemText= homepage.sauceLabsBikeLightTitle.getText().substring(0,21);
        String expectedItemText= "Sauce Labs Bike Light";
        Assert.assertEquals(actualItemText,expectedItemText);
        LOG.info("Item Title is displayed and text validation success");
        homepage.sauceLabsBikeLightDescription.isDisplayed();
        String actualItemDescription= homepage.sauceLabsBikeLightDescription.getText().substring(0, 159);
        String expectedItemDescription="A red light isn't the desired state in testing but it sure helps when riding " +
                "your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescription,expectedItemDescription);
        LOG.info("Item description is displayed and text validation success.");
        homepage.sauceLabsBikeLightPrice.isDisplayed();
        String actualItemPrice= homepage.sauceLabsBikeLightPrice.getText().substring(1,5);
        String expectedItemPrice="9.99";
        Assert.assertEquals(actualItemPrice,expectedItemPrice);
        LOG.info("Item price is displayed and text validation success");


    }
}
