package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(WhatsNewPage.class.getName());

    public WhatsNewPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(xpath = "//div[@class='categories-menu']//ul//a")
    WebElement womenHoodiesSweatshirt;

    //USEFUL METHODS
    public void clickOnWomenHoodiesSweatshirt(){
        clickOn(womenHoodiesSweatshirt);
        LOG.info("click on woman hoodies & sweatshirt success");
    }
}
