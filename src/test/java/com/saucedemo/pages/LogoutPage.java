package com.saucedemo.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutPage {
    WebDriver driver;
    public LogoutPage(WebDriver driver) {
        this.driver = driver;

    }
    By userName = By.id("user-name");
    public void userInHomepage(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(userName).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        By homepageProducts = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
        WebElement productElement = driver.findElement(homepageProducts);
        assertTrue(productElement.isDisplayed());
        assertEquals("Products", productElement.getText());
    }
    public void clickMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

    }
    public void clickLogout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
    public void validateLoginPage(){
        WebElement userLogin = driver.findElement(userName);
        assertTrue(userLogin.isDisplayed());
    }
}
