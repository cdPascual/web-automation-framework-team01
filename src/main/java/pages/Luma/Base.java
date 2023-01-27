package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base extends CommonAPI {
    Logger LOG = LogManager.getLogger(Base.class.getName());

    public Base(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement cartItemCounter;

    public int getTotalItemsInCart(WebDriver driver){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        LOG.info("There "+ getTextFromElement(cartItemCounter)+" item/items in the cart.");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElement(cartItemCounter,"1"));

        return Integer.parseInt(getTextFromElement(cartItemCounter));
    }

}
