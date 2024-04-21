package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_Task1 {
    public static void main(String[] args) {
        /*
        Test case 1
        Gehen Sie zu Ebay
        Suchbegriff  "java" eingeben
        auf die Suchtaste klicken
        Anzahl der Ergebnisse ausdrucken
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        WebElement suchButton = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        suchButton.sendKeys("java");

        WebElement suchtasteClick = driver.findElement(By.xpath("//input[@type='submit']"));
        suchtasteClick.click();

        WebElement ergebnis = driver.findElement(By.xpath("(//span[@class='BOLD'])[14]"));
        System.out.println("ergebnis.getText() = " + ergebnis.getText());

        WebDriverFactory.wait(3);

        driver.close();

    }
}
