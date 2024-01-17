package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Login_PO;

import static utils.Fields.*;

public class Login_Steps extends Login_PO {
    private Login_PO login_po;
    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access to Login Portal")
    public void accessLoginPortal() {
        login_po.navigate_to_login_page();
    }

    @When("I enter username {word}")
    public void enterValidUsername(String userName) {
        login_po.fill_in_Text_Field(USER_NAME, userName);
    }

    @And("I enter password {word}")
    public void enterValidPassword(String password) {
        login_po.fill_in_Text_Field(PASSWORD, password);
    }

    @And("I click on the login button")
    public void clickLoginButton() {
        login_po.click_logIn_button(LOGIN_BUTTON);
    }

    @Then("I should be presented with alert {}")
    public void assertValidationResult
            (String expectedMessage) {
        String actualMessage = getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
