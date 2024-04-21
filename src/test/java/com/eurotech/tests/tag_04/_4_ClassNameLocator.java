package com.eurotech.tests.tag_04;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_ClassNameLocator {
    public static void main(String[] args) {
        /*
         * gehen Sie zur - https://testautomationpractice.blogspot.com/
         * geben Sie "Goethe" in die Wikipedia-Suche ein
         * klicken Sie Suche Button
         * verifizieren Sie, dass Goethe-Links existieren
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement sucheButton = driver.findElement(By.className("wikipedia-search-input"));
        sucheButton.sendKeys("Goethe");

        WebElement clickButton = driver.findElement(By.className("wikipedia-search-button"));
        clickButton.click();

        WebDriverFactory.wait(10);


        WebElement geotheLink = driver.findElement(By.linkText("Goethe"));
        String expectedGoetheTest = geotheLink.getText();
        String actualLinkTest = "Goethe";


        if (expectedGoetheTest.equals(actualLinkTest)){
            System.out.println("Link Test Passed");
        } else {
            System.out.println("Link Test Failed");
        }

        driver.close();

    }
}
