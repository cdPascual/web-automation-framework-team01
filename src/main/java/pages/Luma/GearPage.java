package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GearPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(GearPage.class.getName());

    public GearPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}
