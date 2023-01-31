package pages.Luma;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(xpath ="//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath ="//input[@id='pass']")
    WebElement passwordField;

    @FindBy(xpath ="//button[@class='action login primary']")
    WebElement signInButton;

    @FindBy(xpath ="//div[contains(text(), 'Please enter a valid email address (Ex: johndoe@domain.com).')]")
    WebElement errorMessage;

    //USEFUL METHODS
    public void typeEmailAddress(String emailAddress){
        typeText(emailField, emailAddress);
        LOG.info("type email address success");
    }
    public void typePassword(String password){
        typeText(passwordField, password);
        LOG.info("type password success");
    }

    public void clickOnConnectButton(){
        clickOn(signInButton);
        LOG.info("click sign in button success");
    }

    public String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }
}
