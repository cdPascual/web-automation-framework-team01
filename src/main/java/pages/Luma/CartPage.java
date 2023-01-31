package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CartPage.class.getName());

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS ON CART PAGE
    @FindBy(xpath = "//input[@class='input-text qty']")
    WebElement firstItemQty;

    @FindBy(xpath = "//td[@class='col price']//span//span//span")
    WebElement firstItemPrice;

    @FindBy(xpath = "//td[@class='col subtotal']//span//span//span")
    WebElement firstItemSubTotal;

    @FindBy(xpath = "//a[@class='action action-delete']")
    WebElement deleteIcon;

    @FindBy(xpath = "//div[@class='cart-empty']")
    WebElement emptyCart;

    //USEFUL METHODS
    public void updateCart(String num) throws InterruptedException {
        typeTextEnter(firstItemQty,num);
        Thread.sleep(3000);
    }

    public String getFirstItemPrice(){
        return firstItemPrice.getText();
    }

    public String getTotalPrice(){
        return firstItemSubTotal.getText();
    }

    public void clickOnDeleteIcon(){
        clickOn(deleteIcon);
    }

    public String cartIsEmpty(){
        return getTextFromElement(emptyCart);
    }
}
