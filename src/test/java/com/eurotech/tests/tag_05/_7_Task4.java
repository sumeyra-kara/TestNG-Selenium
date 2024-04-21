package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _7_Task4 {
    public static void main(String[] args) {
        /*
        Test case 4
        Gehen Sie zur https://www.idefix.com/
        Schliessen Sie pop-up, wenn benötigt
        Suchbegriff "Seleniumr" eingeben
        Klicken Sie auf die Suchtaste
        Klicken Sie auf das zweite Produkt
        Verifizieren Sie, dass die Title "Selenium" enthält.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.idefix.com/");

        WebElement cookies = driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]"));
        cookies.click();

        WebElement suchButton  = driver.findElement(By.xpath("//input[@type='text']"));
        suchButton.sendKeys("Seleniumr");
        suchButton.click();

        WebElement zweiteProduct = driver.findElement(By.xpath("(//div[@class='leading-[1.188rem]'])[2]"));
        zweiteProduct.click();

        String actualTitel = driver.getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitel= "Selenium";

        if (actualTitel.contains(expectedTitel)){
            System.out.println("Titel Test Passed");
        } else {
            System.out.println("Titel Test Failed");
        }

        driver.close();


    }
}
