package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    WebDriver driver;

    By usernameInput = By.cssSelector("input#user-name");
    By passwordInput = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");

    }
    public void inputUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);

    }
    public void inputPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);

    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();

    }
    public void validateErrorMessage(String errorMessage){
        assertTrue(driver.getPageSource().contains(errorMessage));

    }
}
