package pages.Luma;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateAccountPage.class.getName());

    public CreateAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();

    @FindBy (xpath = "//fieldset[@class='fieldset create account']//following-sibling::div//div//button//span")
    WebElement createAnAccountButton;

    @FindBy (xpath = "//input[@id='firstname']")
    WebElement firstNameInput;

    @FindBy (xpath = "//input[@id='lastname']")
    WebElement lastNameInput;

    @FindBy (xpath = "//input[@id='email_address']")
    WebElement emailAddressInput;

    @FindBy (xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy (xpath = "//input[@id='password-confirmation']")
    WebElement passwordConfirmInput;


    public void createAnAccount(){
        String fakeID = faker.name().toString();
    }

    public String fakeFirstName() {
        return faker.name().firstName();
    }

    public String fakeLastName() {
        return faker.name().lastName();
    }

    public String fakeEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String fakePassword() {
        return faker.internet().password(8,14,true);
    }

    public void inputFirstName(String firstName) {
        typeText(firstNameInput,firstName);
    }

    public void inputLastName(String lastName) {
        typeText(lastNameInput,lastName);
    }

    public void inputEmailAddress(String email) {
        typeText(emailAddressInput,email);
    }

    public void inputPassword(String password) {;
        typeText(passwordInput,password);
    }

    public void inputConfirmPassword(String password) {
        typeText(passwordConfirmInput,password);
    }

    public void clickCreateAccountButton() {
        clickOn(createAnAccountButton);
    }



}
