package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Fields;
import utils.Global_Vars;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.of;

public class Login_PO extends Base_PO {
    private @FindBy(xpath = "//input[@id='username']")
    WebElement userName_textField;
    private @FindBy(how = How.XPATH, using = "//input[@id='password']")
    WebElement password_textField;
    private @FindBy(how = How.XPATH, using = "//button[@id='signIn']")
    WebElement logIn_button;
    private @FindBy(how = How.XPATH, using = "//li[@id='nav-classes']/a[contains(text(),'Classes')]")
    WebElement classes_tab;
    private @FindBy(how = How.ID, using="classesMonthButton")
    WebElement month_list_option;
    private @FindBy(how = How.ID, using="classesList")
    WebElement month_classes_list;
    private @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-dialog-buttons']")
    WebElement enroll_dialog_widget;

    private WebElement getClassButton_element(String className, String buttonName){
        String xpath =  "(//td/a[@data-eventname='"+className+"']/../preceding-sibling::td/button[@aria-label='"+buttonName+"'])[1]";
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebElement getValidateClassCorrect_element(String className){
        return getDriver().findElement(By.xpath("//p[@class='medium' and contains(normalize-space(),'"+className+"')]"));
    }
    private WebElement getSubmit_button(String buttonName){
        return getDriver().findElement(By.xpath("//button/span[@class='ui-button-text' and contains(text(),'"+buttonName+"')]"));
    }
    private WebElement getConfirmationMessage_element(String messageText){
        return getDriver().findElement(By.xpath("//div[@class='receiptMessage' and contains(text(),'"+messageText+"')]"));
    }
    public Login_PO() {
        super();
    }
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));

    private final Map<Fields, WebElement> fieldStringMapLoginPage = new HashMap<>(
            of(Fields.USER_NAME, userName_textField,
                    Fields.PASSWORD, password_textField,
                    Fields.LOGIN_BUTTON, logIn_button
            )
    );
    public void navigate_to_login_page() {
        navigateToUrl(Global_Vars.RETRO_FITNESS_LANDING_URL);
    }
    public void fill_in_Text_Field(Fields fieldName, String dataToEnter) {
        typeTextString(fieldStringMapLoginPage.get(fieldName), dataToEnter);
    }
    public void click_logIn_button(Fields fieldName) {
        clickElement(fieldStringMapLoginPage.get(fieldName));
    }
    public void confirm_redirection() {
        wait.until(ExpectedConditions.urlToBe(Global_Vars.RETRO_FITNESS_USER_CLASSES_URL));
    }
    public void click_classes_tab() {
        clickElement(classes_tab);
    }
    public void click_month_view_option() {
        clickElement(month_list_option);
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scroll_EnrollOrWait_Button(String className, String buttonName) {
        scrollToElement(getClassButton_element(className, buttonName));
    }

    public void click_EnrollOrWait_Button(String className, String buttonName) {
        clickElement(getClassButton_element(className, buttonName));
    }
    public void confirmEnrollment_popUpMessage(String expectedClassName) {
        wait.until(ExpectedConditions.visibilityOf(enroll_dialog_widget));
        getValidateClassCorrect_element(expectedClassName).getText().contains(expectedClassName);
    }
    public void submit_EnrollmentOrWaiting(String buttonName) {
        clickElement(getSubmit_button(buttonName));
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void validate_ConfirmationMessage(String expectedMessage) {
        wait
                .until(ExpectedConditions
                        .domAttributeToBe(
                                getConfirmationMessage_element(expectedMessage),
                                "class", "receiptMessage"));
        getConfirmationMessage_element(expectedMessage);
    }
}
