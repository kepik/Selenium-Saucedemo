package StepDef;

import Utility.BaseTest;
import pages.HomePage;
import io.cucumber.java.en.Then;

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
