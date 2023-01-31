package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class FitnessEquipmentPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(FitnessEquipmentPage.class.getName());

    public FitnessEquipmentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(xpath = "//div[@id='authenticationPopup']/following-sibling::div/following-sibling::div//ol//li/following-sibling::li/following-sibling::li/following-sibling::li")
    WebElement spriteFoamRoller;

    @FindBy(xpath = "//form[@data-product-sku='24-WG088']")
    WebElement spriteFoamRollerAddToCart;

    //USEFUL METHODS
    public void clickOnSpriteFoamRoller(){
        clickOn(spriteFoamRoller);
    }
    public void addSpriteFoamRollerToCart(WebDriver driver){
        hoverOver(driver, spriteFoamRoller);
        clickOn(spriteFoamRollerAddToCart);

    }
}
