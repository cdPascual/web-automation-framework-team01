package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(WomenPage.class.getName());

    public WomenPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
