package com.saucedemo.StepDef;

import com.saucedemo.BaseTest;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDef extends BaseTest {
    LogoutPage logoutPage;
    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        logoutPage = new LogoutPage(driver);
        logoutPage.userInHomepage();
    }
    @When("User click on the BurgerMenu")
    public void userClickOnTheBurgerMenu() {
        logoutPage.clickMenu();

    }
    @And("Click on the Logout menu")
    public void clickOnTheLogoutMenu() {
        logoutPage.clickLogout();

    }
    @Then("The page is redirected to the login page")
    public void thePageIsRedirectedToTheLoginPage() {

    }
}
