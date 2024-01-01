package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPage {
    WebDriver driver;
    LoginPage loginPage;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void userIsLoggedIn() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    public void addProductToCart() {
        By addProductButton = By.id("add-to-cart-sauce-labs-backpack");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(addProductButton));
        driver.findElement(addProductButton).click();
    }
    public void clickCartPage(){
        By cartButton = By.className("shopping_cart_link");
        driver.findElement(cartButton).click();
    }
    public void validateProductInCart() {
        WebElement productName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        assertEquals("Sauce Labs Backpack", productName.getText());

        By checkOutBtn = By.id("checkout");
        driver.findElement(checkOutBtn).click();
    }
    public void inputCustInfo(String firstName, String lastName, String zipCode) {
        By fName = By.id("first-name");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(fName));

        By lName = By.id("last-name");
        By pCode = By.id("postal-code");

        driver.findElement(fName).sendKeys(firstName);
        driver.findElement(lName).sendKeys(lastName);
        driver.findElement(pCode).sendKeys(zipCode);
    }
    public void continueCheckout(){
        driver.findElement(By.id("continue")).click();

    }
    public void finishCheckout(){
        driver.findElement(By.id("finish")).click();

    }
    public void validateSuccessPage(String thanksMsg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("complete-header")));
        assertTrue(driver.getPageSource().contains(thanksMsg));

        driver.findElement(By.id("back-to-products")).click();
    }

}
