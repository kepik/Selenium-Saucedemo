package com.saucedemo.StepDef;

import com.saucedemo.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.saucedemo.pages.LoginPage;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDef extends BaseTest {
    LoginPage loginPage;

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @And("User input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("User input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("An error message will be displayed {string}")
    public void anErrorMessageWillBeDisplayed(String errorLogin) {
        loginPage.validateErrorMessage(errorLogin);
    }
}
