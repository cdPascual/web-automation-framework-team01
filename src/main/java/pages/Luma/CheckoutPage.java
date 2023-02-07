package pages.Luma;

import base.CommonAPI;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutPage.class.getName());

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();

    @FindBy (xpath = "//div[@class='control']//input[@name='firstname']")
    WebElement firstNameInput;

    @FindBy (xpath = "//div[@class='control']//input[@name='lastname']")
    WebElement lastNameInput;

    @FindBy (xpath = "//div[@class='control _with-tooltip']//input[@type='email']")
    WebElement emailAddressInput;

    @FindBy(xpath = "//div[@class='control _with-tooltip']//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//div[@class='control']//input[@name='street[0]']")
    WebElement addressInput;

    @FindBy(xpath = "//div[@class='control']//input[@name='city']")
    WebElement cityInput;

    @FindBy(xpath = "//div[@class='control']//select[@name='region_id']")
    WebElement regionSelection;

    @FindBy(xpath = "//div[@class='control']//input[@name='postcode']")
    WebElement zipcodeInput;

    @FindBy(xpath = "//div[@class='control']//select[@name='country_id']")
    WebElement countrySelector;

    @FindBy(xpath = "//div[@class='control _with-tooltip']//input[@name='telephone']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//td[@class='col col-method']//input[@name='ko_unique_1']")
    WebElement shippingMethodTableRate;

    @FindBy(xpath = "//td[@class='col col-method']//input[@name='ko_unique_2']")
    WebElement shippingMethodFixed;

    @FindBy(xpath = "//div//button//span[contains(text(),'Next')]")
    WebElement nextButton;

    @FindBy(xpath = "//button[@class='action primary checkout']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//span[contains(text(),'Thank you for your purchase!')]")
    WebElement thankYouText;

    public String fakeFirstName() {
        return faker.name().firstName();
    }

    public String fakeLastName() {
        return faker.name().lastName();
    }

    public String fakeEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String fakeAddress(){
        return faker.address().streetAddress();
    }

    public String fakeCity(){
        return faker.address().city();
    }

    public String fakeZipcode(){
        return faker.address().zipCode();
    }

    public String fakePhoneNumber(){
        return faker.phoneNumber().cellPhone();
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
    public void inputAddress(String address) {
        typeText(addressInput,address);
    }
    public void inputCity(String city) {
        typeText(cityInput,city);
    }
    public void selectRegion(int stateProvince) {
        Select select = new Select(regionSelection);
        select.selectByIndex(stateProvince);
    }
    public void inputZipcode(String zipcode) {
        typeText(zipcodeInput,zipcode);
    }
    public void selectCountry(int country) {
        Select select = new Select(countrySelector);
        select.selectByIndex(country);
    }
    public void inputPhoneNumber(String phoneNumber) {
        typeText(phoneNumberInput,phoneNumber);
    }

    public void selectTableRateShippingMethod() {
        shippingMethodTableRate.click();
    }
    public void selectFixedShippingMethod() {
        shippingMethodFixed.click();
    }

    public void clickNextButton(){
        clickOn(nextButton);
    }

    public void clickPlaceOrderButton(){
        clickOn(placeOrderButton);
    }

    public String getThankYouText(){
        return thankYouText.getText();
    }

}
