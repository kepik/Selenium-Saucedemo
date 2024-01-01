package StepDef;

import pages.CheckoutPage;
import io.cucumber.java.en.*;
import pages.LoginPage;
import static Utility.BaseTest.*;

public class CheckoutStepDef {
    CheckoutPage checkoutPage;
    LoginPage loginPage;

    @Given("User is logged in")
    public void userIsLoggedIn() {
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


    @And("User click on the Checkout button")
    public void userClickOnTheCheckoutButton() {
        checkoutPage.clickCartPage();
        checkoutPage.validateProductInCart();
    }
    @And("User input info details {string}, {string}, {string}")
    public void userInputInfoDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.inputCustInfo(firstName,lastName,zipCode);
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
