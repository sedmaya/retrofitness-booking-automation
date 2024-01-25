package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));

    public String generateRandomNumber(int num) {
        return RandomStringUtils.randomNumeric(num);
    }

    public String generateRandomString(int num) {
        return RandomStringUtils.randomAlphabetic(num);
    }

    protected void navigateToUrl(String url) {
        getDriver().get(url);
    }

    protected void typeTextString(WebElement element, String textToEnter) {
      //  WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToEnter);
    }
    protected void scrollToElement(WebElement element) {
        try{
           wait.until(ExpectedConditions.visibilityOf(element));
        }catch (NoSuchElementException e){
            throw new RuntimeException("Web element not visible within given time" + element);
        }
      //  element.sendKeys(Keys.DOWN);

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
    }
    protected void clickElement(WebElement element) {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (NoSuchElementException e){
            throw new RuntimeException("Web element not visible within given time" + element);
        }

    }
}