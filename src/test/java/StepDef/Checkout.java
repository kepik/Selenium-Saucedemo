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

public class Checkout {
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

    @Given("User is already login")
    public void userIsAlreadyLogin() {
        By homepageProducts = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
        WebElement productElement = driver.findElement(homepageProducts);
        assertTrue(productElement.isDisplayed());
        assertEquals("Products", productElement.getText());
    }

    @When("User click on the Add to Cart button")
    public void userClickOnTheAddToCartButton() {
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("The product is added into the cart")
    public void theProductIsAddedIntoTheCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("Validate the product in the cart")
    public void validateTheProductInTheCart() {
        WebElement productName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        assertEquals("Sauce Labs Backpack", productName.getText());
    }

    @Given("The product is added to the cart")
    public void theProductIsAddedToTheCart() {
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div")));

        WebElement productName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        assertEquals("Sauce Labs Backpack", productName.getText());
    }

    @And("User click on the Checkout button")
    public void userClickOnTheCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User input {string}, {string}, {string}")
    public void userInput(String firstName, String lastName, String zipCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }

    @When("Click the Continue button")
    public void clickTheContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("Click the Finish button")
    public void clickTheFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("The page shows page {string}")
    public void thePageShowsPage(String successMsg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("complete-header")));
        assertTrue(driver.getPageSource().contains(successMsg));

        driver.findElement(By.id("back-to-products")).click();
    }
}
