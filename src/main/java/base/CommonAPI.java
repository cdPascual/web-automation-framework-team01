package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class CommonAPI {
    Logger Log = LogManager.getLogger(CommonAPI.class.getName());
    public WebDriver driver;

    public void getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @Parameters({"url","browserName"})
    @BeforeMethod
    public void setUp(String url, String browserName) {
        getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        Log.info("browser has closed!");
    }
    public void clickOn(String cssOrXpath){
        try{
            driver.findElement(By.cssSelector(cssOrXpath)).click();
        }catch(Exception e){
            driver.findElement(By.xpath(cssOrXpath)).click();
        }
    }

    public void typeText(String cssOrXpath, String text){
        try{
            driver.findElement(By.cssSelector(cssOrXpath)).sendKeys(text);
        }catch(Exception e){
            driver.findElement(By.xpath(cssOrXpath)).sendKeys(text);
        }
    }

    public void typeTextEnter(String cssOrXpath, String text){
        try{
            driver.findElement(By.cssSelector(cssOrXpath)).sendKeys(text, Keys.ENTER);
        }catch(Exception e){
            driver.findElement(By.xpath(cssOrXpath)).sendKeys(text, Keys.ENTER);
        }

    }

    public void selectOptionFromDropdown(String cssOrXpath, String option){
        WebElement dropdown;
        try{
            dropdown = driver.findElement(By.cssSelector(cssOrXpath));
            Select select = new Select(dropdown);
            try{
                select.selectByVisibleText(option);
            }catch(Exception e2){
                select.selectByValue(option);
            }

        }catch(Exception e){
            dropdown = driver.findElement(By.xpath(cssOrXpath));
            Select select = new Select(dropdown);
            try{
                select.selectByVisibleText(option);
            }catch(Exception e2){
                select.selectByValue(option);
            }

        }

    }

    public String getTextFromElement(String cssOrXpath){
        try{
            return driver.findElement(By.cssSelector(cssOrXpath)).getText();
        } catch(Exception e){
            return driver.findElement(By.xpath(cssOrXpath)).getText();
        }
    }

    public void hoverOver(String cssOrXpath){
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(driver.findElement(By.cssSelector(cssOrXpath))).build().perform();
        }catch (Exception e){
            actions.moveToElement(driver.findElement(By.xpath(cssOrXpath))).build().perform();
        }
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }
}
