package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Login_PO;
import utils.Global_Vars;

import java.time.Duration;

import static utils.Fields.*;

public class Login_Steps extends Login_PO {
    private final Login_PO login_po;

    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access to Login Portal")
    public void i_access_to_login_portal() {
        login_po.navigate_to_login_page();
    }

    @When("I enter username {string}")
    public void i_enter_username(String userName) {
        login_po.fill_in_Text_Field(USER_NAME, userName);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        login_po.fill_in_Text_Field(PASSWORD, password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        login_po.click_logIn_button(LOGIN_BUTTON);
    }

    @And("I redirected to my Account home page {string}")
    public void i_redirected_to_my_account_home_page(String expectedURL) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.urlToBe(expectedURL));
    }

    @And("I click on Classes tab")
    public void iClickOnClassesTab() {
        login_po.click_classes_tab();
    }

    @And("I redirected to Classes sign up page")
    public void iRedirectedToClassesSignUpPage() {
        login_po.confirm_redirection();
    }

    @And("I click Month list view")
    public void iClickMonthListView() {
        login_po.click_month_view_option();
    }
    @And("I scroll to the {string} Class {string} button")
    public void iScrollToTheClassButton(String className, String buttonName) {
        login_po.scroll_EnrollOrWait_Button(className, buttonName);
    }
    @And("Next to the {string} Class I click on {string} button")
    public void nextToTheClassIClickOnButton(String className, String buttonName) {
        login_po.click_EnrollOrWait_Button(className, buttonName);
    }

    @And("I see pop up to confirm enrollment in {string} Class")
    public void iSeePopUpToConfirmEnrollmentInClass(String className) {
        login_po.confirmEnrollment_popUpMessage(className);
    }
    @And("I click {string} button on the pop up window")
    public void iClickButtonOnThePopUpWindow(String buttonName) {
        login_po.submit_EnrollmentOrWaiting(buttonName);
    }

    @Then("I should be presented with a confirmation message that contains {string}")
    public void iShouldBePresentedWithAConfirmationMessageThatContains(String expectedMessage) {
        login_po.validate_ConfirmationMessage(expectedMessage);
    }
}
