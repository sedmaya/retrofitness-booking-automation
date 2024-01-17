package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public String generateRandomNumber(int num) {
        return RandomStringUtils.randomNumeric(num);
    }

    public String generateRandomString(int num) {
        return RandomStringUtils.randomAlphabetic(num);
    }

    protected void navigateToUrl(String url) {
        getDriver().get(url);
    }

    protected void typeTextString(By by, String textToEnter) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToEnter);
    }

    protected void typeTextString(WebElement element, String textToEnter) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToEnter);
    }

    protected void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }

    protected void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
}