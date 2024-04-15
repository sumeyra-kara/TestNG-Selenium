package com.eurotech.tests.tag_03;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatTest {
    public static void main(String[] args) {

        /*
         * Gehen Sie zu "https://www.saucedemo.com/"
         * Füllen Sie das Feld für den Username aus - "standard_user"
         * Füllen Sie das Password aus - "secret_sauce"
         * Klicken Sie auf die Login-Taste
         * Verifizieren Sie, dass sich die URL geändert hat - "https://www.saucedemo.com/inventory.html"
         * Verifizieren Sie den Text oben auf der Seite - "Swag Labs"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword=driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement inputLoginButton = driver.findElement(By.id("login-button"));
        inputLoginButton.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url test passed");
        } else {
            System.out.println("Url test failed");
        }

        String expectedSwagLabsText = "Swag Labs";
        WebElement actualSwagLabs = driver.findElement(By.className("app_logo"));// classname methodu icin String'e atama yapmaliyim.direkt yazdiramam

        String actualSwagLabsTest=actualSwagLabs.getText();
        System.out.println("actualSwagLabsTest = " + actualSwagLabsTest);

        if (expectedSwagLabsText.equals(actualSwagLabsTest)){
            System.out.println("Swag Labs Test passed");
        } else{
            System.out.println("Swag Labs Test Failed");
        }







    }
}
