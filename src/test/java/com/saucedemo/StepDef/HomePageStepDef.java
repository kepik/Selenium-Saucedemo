package com.saucedemo.StepDef;

import com.saucedemo.BaseTest;
import com.saucedemo.pages.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageStepDef extends BaseTest {
    HomePage homePage;

    @Then("User will be redirected to the homepage")
    public void userWillBeRedirectedToTheHomepage() {
       homePage = new HomePage(driver);
       homePage.validateOnHomePage();
    }
}
