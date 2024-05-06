package com.eurotech.tests.tag_07;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Task {
    /*
     * Gehen Sie zu "https://www.saucedemo.com/"
     * Füllen Sie das Feld für den Username aus - "standard_user"
     * Füllen Sie das Password aus - "secret_sauce"
     * Klicken Sie auf die Login-Taste
     * Legen Sie das erste Produkt in den Warenkorb
     * Gehen Sie zum Warenkorb
     * Verifizieren Sie Kosten und Quantitat
     *
     *  * Gehen Sie zu "https://www.saucedemo.com/"
     * Füllen Sie das Feld für den Username aus - "standard_user"
     * Füllen Sie das Password aus - "secret_sauce"
     * Klicken Sie auf die Login-Taste
     * Legen Sie das erste Produkt in den Warenkorb
     * Gehen Sie zum Warenkorb
     * Löschen Sie dieses Produkt aus dem Warenkorb
     * Verifizieren Sie, dass der Warenkorb leer ist
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        WebElement ersteProduct = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        ersteProduct.click();
        WebElement warenkorb =driver.findElement(By.cssSelector("#shopping_cart_container"));
        warenkorb.click();
    }

    @Test(priority = 1)
    public void warenkorb(){
        WebElement kosten = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        String actualKosten = kosten.getText();
        String expectedKosten = "$29.99";
        Assert.assertEquals(actualKosten,expectedKosten);

        WebElement quantitat = driver.findElement(By.xpath("//div[@class='cart_quantity']"));
        String actualQuantitat = quantitat.getText();
        String expectedQuantitat = "1";
        Assert.assertEquals(actualQuantitat,expectedQuantitat);
    }

    @Test (priority = 0)
    public void leereWarenkorb (){
        WebElement leereWarenkorb = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        leereWarenkorb.click();
        WebElement text = driver.findElement(By.cssSelector("#continue-shopping"));
        String actualMessage = text.getText();
        Assert.assertTrue(actualMessage.contains("Continue Shopping"));
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }


}

