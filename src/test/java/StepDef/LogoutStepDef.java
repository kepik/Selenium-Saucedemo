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
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutStepDef {
    WebDriver driver;
    @Before
    public void beforeAll() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @After
    public void afterAll() {
        driver.close();
    }

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        By homepageProducts = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
        WebElement productElement = driver.findElement(homepageProducts);
        assertTrue(productElement.isDisplayed());
        assertEquals("Products", productElement.getText());
    }

    @When("User click on the Burgermenu")
    public void userClickOnTheBurgermenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("Click on the Logout menu")
    public void clickOnTheLogoutMenu() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("The page is redirected to the login page")
    public void thePageIsRedirectedToTheLoginPage() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        assertTrue(usernameField.isDisplayed());
        System.out.println("Logout Success");
    }
}
