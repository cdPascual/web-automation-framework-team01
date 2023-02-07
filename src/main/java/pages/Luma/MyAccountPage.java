package pages.Luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    Logger LOG = LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[contains(text(),'My Wish List')]")
    WebElement myWishList;
    @FindBy(xpath = "//button[@title='Add All to Cart']")
    WebElement addAllToCart;

//    @FindBy(xpath = "")
//    @FindBy(xpath = "")
//    @FindBy(xpath = "")


}
