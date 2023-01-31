package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WatchesPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(WatchesPage.class.getName());

    public WatchesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(xpath = "//div[@id='authenticationPopup']/following-sibling::div/following-sibling::div//ol//li/following-sibling::li")
    WebElement clamberWatch;

    @FindBy(xpath = "//form[@data-product-sku='24-WG03']")
    WebElement clamberWatchAddToCart;

    //METHOD
    public void addClamberWatchToCart(WebDriver driver){
        hoverOver(driver, clamberWatch);
        clickOn(clamberWatchAddToCart);
    }
}
