package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    WebDriver driver;
    By backpackProduct = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void validateOnHomePage() {
        assertTrue(driver.findElement(backpackProduct).isDisplayed());

    }

}
