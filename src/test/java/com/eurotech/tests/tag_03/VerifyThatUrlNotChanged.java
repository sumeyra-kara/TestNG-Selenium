package com.eurotech.tests.tag_03;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChanged {

    public static void main(String[] args) {
        /*
         * Gehen Sie zu https://www.saucedemo.com/
         * Füllen Sie das Feld für den Username aus
         * Füllen Sie das Password aus
         * Klicken Sie auf die Login-Taste
         * Verifizieren Sie, dass sich die URL nicht geändert hat.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("user123"); //Web Element'e istenen metni yollar


        WebElement inputPassword=driver.findElement(By.id("password"));
        inputPassword.sendKeys("2134");

        WebElement inputLoginButton = driver.findElement(By.id("login-button"));
        inputLoginButton.click();

        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();
        // System.out.println(actualUrl);   - https://www.saucedemo.com/

        if (expectedUrl.contains(actualUrl)){
            System.out.println("Url test passed");
        } else {
            System.out.println("Url test failed");
        }

        driver.quit();






    }
}
