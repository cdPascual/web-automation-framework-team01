package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //objects
    @FindBy(css = "#search")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='action search']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@id='ui-id-4']")
    WebElement floatingMenu;

    @FindBy(xpath = "//li[@class='authorization-link']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@id='ui-id-3']")
    WebElement whatsNewMenuItem;

//    @FindBy(css = "#searchDropdownBox")
//    WebElement menuDropdown;

    //reusable steps
    public void typeInSearch(String item){
        typeText(searchField, item);
        LOG.info("item type success");
    }

    public void clickOnSearchButton(){
        clickOn(searchButton);
        LOG.info("click on search success");
    }

    public void searchItem(String item){
        typeTextEnter(searchField, item);
        LOG.info("type and enter in search bar success");
    }

//    public void selectOptionFromMenuDropdown(String option){
//        selectOptionFromDropdown(menuDropdown, option);
//        LOG.info(option + " option selected from the dropdown");
//    }

    public void hoverOverFloatingMenu(WebDriver driver){
        hoverOver(driver, floatingMenu);
        LOG.info("hover over menu success");
    }

    public void clickOnLoginButton(){
        clickOn(loginButton);
    }

    public void clickOnWhatsNewMenuItem(){
        clickOn(whatsNewMenuItem);
    }

}
