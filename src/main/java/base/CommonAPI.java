package base;

import jdk.jshell.execution.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CommonAPI {
    String userName = Utility.decode(Utility.getProperties().getProperty("browserstack.username"));
    String password = Utility.decode(Utility.getProperties().getProperty("browserstack.password"));

    //Logger LOG = LogManager.getLogger(CommonAPI.class.getName());
    public WebDriver driver;

    public void getLocalDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            driver= new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
    }

    public void getCloudDriver(String os, String osVersion, String browser, String browserVersion, String userName, String password) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser",browser);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("resolution","1024x768");
        driver = new RemoteWebDriver(new URL("http://"+userName+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"), cap);


    }

    @Parameters({"useCloudEnv","os","osVersion","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv,@Optional("windows") String os,
                      @Optional("11") String osVersion, @Optional("Chrome") String browserName,
                      @Optional("108") String browserVersion, @Optional("https://www.Google.com") String url) throws MalformedURLException {
        if(useCloudEnv){
            System.out.println(userName);
            System.out.println(password);
            getCloudDriver(os,osVersion,browserName,browserVersion, userName,password);
        }else{
            getLocalDriver(browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        //LOG.info("browser has closed!");
    }
    public WebDriver getDriver(){
        return driver;
    }

    public void clickOn(WebElement element){
        element.click();
    }

    public void typeText(WebElement element, String text ){
        element.sendKeys(text);
    }

    public void typeTextEnter(WebElement element, String text){
        element.sendKeys(text, Keys.ENTER);

    }

    public void selectOptionFromDropdown(WebElement dropdown, String option){
        Select select = new Select(dropdown);

        try{
            select.selectByVisibleText(option);
        }catch(Exception e){
            select.selectByValue(option);
        }

    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public void hoverOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }
}