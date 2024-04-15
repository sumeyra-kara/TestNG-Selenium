package com.eurotech.tests.tag_03;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlChanged {
    public static void main(String[] args) {
        /*
         * Gehen Sie zu "https://www.saucedemo.com/"
         * Füllen Sie das Feld für den Username aus - "standard_user"
         * Füllen Sie das Password aus - "secret_sauce"
         * Klicken Sie auf die Login-Taste
         * Verifizieren Sie, dass sich die URL geändert hat - "https://www.saucedemo.com/inventory.html"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");

        //  Füllen Sie das Feld für den Username aus - "standard_user"
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        // Füllen Sie das Password aus - "secret_sauce"
        WebElement inputPassword=driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");


        WebElement inputLoginButton = driver.findElement(By.id("login-button"));
        inputLoginButton.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        // System.out.println(expectedUrl);

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url test passed");
        } else {
            System.out.println("Url test failed");
        }

        //driver.quit();
    }
}
