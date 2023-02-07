package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(MyWishListPage.class.getName());

    public MyWishListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class='toolbar-number']")
    WebElement itemsInWishlist;

    @FindBy(xpath = "//button[@title='Add All to Cart']")
    WebElement addAllItemsToCart;

    @FindBy(xpath = "//div[@class='message info empty']//span")
    WebElement emptyMessage;

    public String getTotalItemsWishList(){
        return itemsInWishlist.getText();
    }

    public void clickAddAllItemsToCart(){
        clickOn(addAllItemsToCart);
    }

    public String getEmptyMessage(){
        return emptyMessage.getText();
    }

}
