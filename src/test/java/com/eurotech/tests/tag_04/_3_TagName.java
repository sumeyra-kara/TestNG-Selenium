package com.eurotech.tests.tag_04;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_TagName {
    public static void main(String[] args) {
        /*
         * gehen Sie zur - https://the-internet.herokuapp.com/
         * Verifizieren Sie den Text oben auf der Seite - Welcome to the-internet
         * Verifizieren Sie den Text oben auf der Seite - Available Examples
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/");

        WebElement welcomeElement = driver.findElement(By.tagName("h1"));
        //System.out.println("welcomeText.getText() = " + welcomeText.getText());

        String expectedWelcomeTest = "Welcome to the-internet";
        String actualWelcomeTest = welcomeElement.getText();

        if (expectedWelcomeTest.equals(actualWelcomeTest)){
            System.out.println("Erste Element Test passed");
        } else {
            System.out.println("Erste Element Test failed");
        }


        WebElement availableElement  = driver.findElement(By.tagName("h2"));

        String expectedElementTest = "Available Examples";
        String actualElementTest = availableElement.getText();
        //System.out.println("actualElement = " + actualElement);

        if (actualElementTest.equals(expectedElementTest)){
            System.out.println("Zweite Element Test Passed");
        } else {
            System.out.println("Zweite Element Test Passed");
        }

        driver.close();
    }
}
