package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _7_Task2 {
    public static void main(String[] args) {
        /*
        Aufgabe 2
        Gehen Sie zur https://www.amazon.sg/
        Suchbegriff "selenium" eingeben
        auf die Suchtaste klicken
        Klicken Sie auf einen der Preise links auf der Seite
        die Preise und Namen der ersten drei Produkte auf der Konsole ausgeben
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.sg/");
        WebDriverFactory.wait(2);

        WebElement suchBegriff = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        suchBegriff.sendKeys("selenium");
        WebDriverFactory.wait(2);

        WebElement suchTaste = driver.findElement(By.cssSelector("input[value='Go']"));
        suchTaste.click();
        WebDriverFactory.wait(2);

        WebElement ersteProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ersteProduct.click();

        WebElement nameErsteProduct = driver.findElement(By.cssSelector("#productTitle"));
        System.out.println("nameErsteProduct.getText() = " + nameErsteProduct.getText());

        WebElement preisErsteProduct = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
        System.out.println("preisErsteProduct.getText() = " + preisErsteProduct.getText());

        driver.navigate().back();

        // zweiteProduct
        WebElement zweiteProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        zweiteProduct.click();

        WebElement nameZweiteProduct = driver.findElement(By.cssSelector(".a-size-large.product-title-word-break"));
        System.out.println("nameZweiteProduct.getText() = " + nameZweiteProduct.getText());

        WebDriverFactory.wait(2);

        driver.navigate().back();

        //dritteProduct
        WebElement dritteProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]"));
        dritteProduct.click();

        WebElement nameDritteProduct = driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']"));
        System.out.println("nameDritteProduct.getText() = " + nameDritteProduct.getText());

        WebDriverFactory.wait(2);


        driver.close();


    }
}
