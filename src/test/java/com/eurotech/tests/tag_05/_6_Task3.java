package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_Task3 {
    public static void main(String[] args) {
        /*
        Test case 3
        Gehen Sie zu wikipedia.org (Links zu einer externen Seite.)
        Suchbegriff "Selenium Webdriver" eingeben
        Klicken Sie auf die Suchtaste
        Klicken Sie auf das Suchergebnis Selenium (Software)
        Verifizieren Sie, dass die URL mit "Selenium_(Software)" endet.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");


        WebElement suchBegriff = driver.findElement(By.xpath("//input[@id='searchInput']"));
        suchBegriff.sendKeys("Selenium Webdriver");

        WebElement suchTaste = driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
        suchTaste.click();

        WebElement seleniumElement = driver.findElement(By.xpath("//span[text()='Selenium']"));
        seleniumElement.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "Selenium_(Software)";

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        if (actualUrl.endsWith(expectedUrl)){
            System.out.println("Url Test Passed");
        }else
            System.out.println("Url Test Failed");

        driver.close();
    }
}
