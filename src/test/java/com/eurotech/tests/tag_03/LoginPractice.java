package com.eurotech.tests.tag_03;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPractice {
    public static void main(String[] args) {

       /*
        * Gehen Sie zu "https://the-internet.herokuapp.com/login"
        * Füllen Sie das Feld für den Username aus - "tomsmith"
        * Füllen Sie das Password aus - "SuperSecretPassword!"
        * Klicken Sie auf die Login-Taste
        * Verifizieren Sie, dass sich die URL geändert hat - "https://the-internet.herokuapp.com/secure"
        * Verifizieren Sie den Text oben auf der Seite - "Secure Area"
        * Verifizieren Sie alle Attributevalues von "Elemental Selenium"
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        String expectedUrl= driver.getCurrentUrl();
        String actualUrl = "https://the-internet.herokuapp.com/secure";
        System.out.println("expectedUrl = " + expectedUrl); // https://the-internet.herokuapp.com/secure

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url test passed");
        } else {
            System.out.println("uRL test failed");
        }


        String expectedTextSecureArea = " Secure Area";
        WebElement securaArea = driver.findElement(By.tagName("h2"));
        String actualTextSecureArea = securaArea.getText();

        System.out.println("actualTextSecureArea.isEmpty() = " + actualTextSecureArea.isEmpty());

        System.out.println("actualTextSecureArea = " + actualTextSecureArea);


        if (actualTextSecureArea.equals(expectedTextSecureArea)){
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }


        String text = "Elemental Selenium";
        WebElement elementalSelenium = driver.findElement(By.partialLinkText(text));

        String targetAttribute=elementalSelenium.getAttribute("target");
        String expectedTargetAttribute = "_blank";
        String actualTargetAttribute = targetAttribute;

        if (expectedTargetAttribute.equals(actualTargetAttribute)){
            System.out.println("Target Attribute Test Passed");
        } else {
            System.out.println("Target Attribue Test Failed");
        }

        String hrefAttribute = elementalSelenium.getAttribute("href");
        String expectedHrefAttribute = "http://elementalselenium.com/";
        String actualHrefAttribute = hrefAttribute;

        if (expectedHrefAttribute.equals(actualHrefAttribute)){
            System.out.println("Href Attribute Test Passed");
        } else {
            System.out.println("Href Attribute Test Failed");
        }

        driver.quit();




    }
}
