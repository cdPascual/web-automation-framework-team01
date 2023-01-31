package pages.Luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    Logger LOG = LogManager.getLogger(Base.class.getName());

    public Base(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
