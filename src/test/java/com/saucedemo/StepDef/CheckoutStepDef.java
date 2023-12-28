package com.saucedemo.StepDef;

import com.saucedemo.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDef extends BaseTest {
    CheckoutPage checkoutPage;

    @Given("User is already login")
    public void userIsAlreadyLogin() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.userIsLoggedIn();
    }
    @When("User click on the Add to Cart button")
    public void userClickOnTheAddToCartButton() {
       checkoutPage.addProductToCart();

    }
    @Then("The product is added into the cart")
    public void theProductIsAddedIntoTheCart() {
        checkoutPage.clickCartPage();

    }
    @And("Validate the product in the cart")
    public void validateTheProductInTheCart() {
        checkoutPage.validateProductInCart();

    }
    @Given("The product is added to the cart")
    public void theProductIsAddedToTheCart() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.userIsLoggedIn();
        checkoutPage.validateProductInCart();
    }
    @And("User click on the Checkout button")
    public void userClickOnTheCheckoutButton() {
        checkoutPage.clickCartPage();

    }
    @And("User input info details")
    public void userInputInfoDetails() {
        checkoutPage.inputCustInfo();

    }
    @When("Click the Continue button")
    public void clickTheContinueButton() {
        checkoutPage.continueCheckout();

    }
    @And("Click the Finish button")
    public void clickTheFinishButton() {
        checkoutPage.finishCheckout();

    }
    @Then("The page shows page {string}")
    public void thePageShowsPage(String successMsg) {
        checkoutPage.validateSuccessPage(successMsg);
    }
}
