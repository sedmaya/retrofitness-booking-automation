package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Fields;
import utils.Global_Vars;

import java.util.HashMap;
import java.util.Map;

public class Login_PO extends Base_PO {
    private @FindBy(xpath = "//form[@class='form']/input[@id='text']")
    WebElement userName_textField;
    private @FindBy(how = How.XPATH, using = "//form[@class='form']/input[@id='password']")
    WebElement password_textField;
    private @FindBy(how = How.ID, using = "login-button")
    WebElement logIn_button;

    public Login_PO() {
        super();
    }

    private final Map<Fields, WebElement> fieldStringMapLoginPage = new HashMap<>(
            Map.of(Fields.USER_NAME, userName_textField,
                    Fields.PASSWORD, password_textField,
                    Fields.LOGIN_BUTTON, logIn_button));

    public void navigate_to_login_page() {
        navigateToUrl(Global_Vars.WEBDRIVER_UNIVERSITY_LANDING_URL + "/Login-Portal/index.html");
    }

    public void fill_in_Text_Field(Fields fieldName, String dataToEnter) {
        typeTextString(fieldStringMapLoginPage.get(fieldName), dataToEnter);
    }

    public void click_logIn_button(Fields fieldName) {
        clickElement(fieldStringMapLoginPage.get(fieldName));
    }
}
