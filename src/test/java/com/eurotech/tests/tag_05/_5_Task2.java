package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_Task2 {
    public static void main(String[] args) {
        /*
        Test case 2
        Zu Ebay gehen
        Selenium suchen
        Klicken Sie auf die Suchtaste
        Verifizieren, ob der Titel Selenium enthält
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        WebElement suchButton = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        suchButton.sendKeys("selenyum");

        WebElement suchtasteClick = driver.findElement(By.xpath("//input[@type='submit']"));
        suchtasteClick.click();

        String actualTitel = driver.getTitle();
        String expectedTitel = "Selenium";

        if (actualTitel.contains(expectedTitel)){
            System.out.println("Titel Test Passed");
        } else {
            System.out.println("Titel Test Failed");
        }

        WebDriverFactory.wait(3);

        driver.close();


    }
}
