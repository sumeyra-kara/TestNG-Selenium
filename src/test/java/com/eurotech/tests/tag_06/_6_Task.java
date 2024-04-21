package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_Task {
    public static void main(String[] args) {
        /*
    Aufgabe 1
    Gehen Sie zur https://www.amazon.sg/
    Suchbegriff "java" eingeben
    auf die Suchtaste klicken
    Klicken Sie auf das erste Produkt
    Verifizieren Sie den Produktname
    Verifizieren Sie den Preis

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.sg/");
        WebDriverFactory.wait(2);

        WebElement suchBegriff = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        suchBegriff.sendKeys("java");
        WebDriverFactory.wait(2);

        WebElement suchTaste = driver.findElement(By.cssSelector("input[value='Go']"));
        suchTaste.click();
        WebDriverFactory.wait(2);

        WebElement ersteElement = driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal"));
        ersteElement.click();

        WebElement produktName = driver.findElement(By.cssSelector("#productTitle"));

        String actualName = produktName.getText();
        String expectedName = "Head First Java, 3rd Edition: A Brain-Friendly Guide";

        if (actualName.equals(expectedName)){
            System.out.println("Produktname Test Passed");
        }else
            System.out.println("Produktname Test Failed");

        WebElement preis = driver.findElement(By.cssSelector(".a-size-medium.a-color-price.header-price.a-text-normal"));

        String actualPreis = preis.getText();
        String expectedPreis = "S$98.84";

        if (actualPreis.equals(expectedPreis)){
            System.out.println("Preis Test Passed");
        } else
            System.out.println("Preis Test Failed");

        WebDriverFactory.wait(2);

        driver.close();



    }

}