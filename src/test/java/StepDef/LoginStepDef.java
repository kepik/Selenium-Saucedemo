package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDef {
    WebDriver driver;

    @Before
    public void beforeTest() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }
    @After
    public void afterTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("User input username with {string}")
    public void userInputUsernameWith(String username) {
        By usernameInput = By.cssSelector("input#user-name");
        driver.findElement(usernameInput).sendKeys(username);
    }

    @And("User input password with {string}")
    public void userInputPasswordWith(String password) {
        By passwordInput = By.xpath("//*[@id=\"password\"]");
        driver.findElement(passwordInput).sendKeys(password);
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        By loginButton = By.id("login-button");
        driver.findElement(loginButton).click();
    }

    @Then("User will be redirected to the homepage")
    public void userWillBeRedirectedToTheHomepage() {
        By homepageProducts = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
        WebElement productElement = driver.findElement(homepageProducts);
        assertTrue(productElement.isDisplayed());
        assertEquals("Products", productElement.getText());
    }

    @Then("An error message will be displayed {string}")
    public void anErrorMessageWillBeDisplayed(String errorLogin) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
        assertTrue(driver.getPageSource().contains(errorLogin));
    }
}
