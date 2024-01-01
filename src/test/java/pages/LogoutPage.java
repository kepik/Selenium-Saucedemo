package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutPage {
    WebDriver driver;
    LoginPage loginPage;
    public LogoutPage(WebDriver driver) {
        this.driver = driver;

    }
    public void userInHomepage(){
        loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    public void clickMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

    }
    public void clickLogout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
    public void validateLoginPage(){
        By userName = By.id("user-name");
        WebElement userLogin = driver.findElement(userName);
        assertTrue(userLogin.isDisplayed());
    }
}
