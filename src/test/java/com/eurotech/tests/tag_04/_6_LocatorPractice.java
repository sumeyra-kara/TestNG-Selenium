package com.eurotech.tests.tag_04;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _6_LocatorPractice {
    public static void main(String[] args) {
        /*
         * Gehen Sie zu https://www.automationexercise.com/
         * Klicken Sie auf "Products"
         * Legen Sie das erste Produkt in den Warenkorb
         * Verifizieren Sie die Anzahl der Produkte(Quantity)
         * Verifizieren Sie den Totalbetrag
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();


        WebElement productsElement = driver.findElement(By.partialLinkText(" Products"));
        productsElement.click();

        WebDriverFactory.wait(5);

        WebElement addToCard = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        WebDriverFactory.wait(3);
        // Actions actions = new Actions(driver);
        //actions.moveToElement(addToCard);
       // WebDriverFactory.wait(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCard);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCard);
        WebDriverFactory.wait(3);


        WebElement viewCard = driver.findElement(By.linkText("View Cart"));

        viewCard.click();
        WebDriverFactory.wait(2);

        WebElement quantity = driver.findElement(By.className("disabled"));
        String quantityText = quantity.getText();
        System.out.println("quantityText = " + quantityText);

        if (quantityText.equals("1")){
            System.out.println("Quantity Test Passed");
        } else {
            System.out.println("Quantity Test Failed");
        }


        WebElement totalBetrag = driver.findElement(By.className("cart_total_price"));
        String betrag = totalBetrag.getText();
        betrag = betrag.replaceAll("\\D", "");
        System.out.println("betrag = " + betrag);

        if (betrag.equals("500")){
            System.out.println("Total Betrag Test Passed");
        } else {
            System.out.println("Total Betrag Test Failed");
        }




    }
}
