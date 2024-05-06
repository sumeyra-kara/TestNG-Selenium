package com.eurotech.tests.tag_14;
import com.eurotech.utility.ConfigReader;
import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _1_ConfigurationPropertiesTest {
    @Test
    public void test1() {

        String browser = ConfigReader.getProperty("browser");
        System.out.println("browser = " + browser);
        String url = ConfigReader.getProperty("url");
        System.out.println("url = " + url);
    }

    @Test
    public void loginTest() {
        String browser = ConfigReader.getProperty("browser");
        WebDriver driver = WebDriverFactory.getDriver(browser);
        driver.get(ConfigReader.getProperty("url"));

        driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        String username = ConfigReader.getProperty("username");
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        String password = ConfigReader.getProperty("password");
        passwordInput.sendKeys(password + Keys.ENTER);

    }
}
