package com.saucedemo.pages;

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
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

    }
    public void userIsLoggedIn() {
        By usernameInput = By.id("user-name");
        By passwordInput = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameInput).sendKeys("standard_user");
        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }
    public void addProductToCart() {
        By addProductButton = By.id("add-to-cart-sauce-labs-backpack");
        driver.findElement(addProductButton).click();
    }
    public void clickCartPage(){
        driver.findElement(By.className("shopping_cart_link")).click();

    }
    public void validateProductInCart() {
        WebElement productName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        assertEquals("Sauce Labs Backpack", productName.getText());
    }
    public void inputCustInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
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
