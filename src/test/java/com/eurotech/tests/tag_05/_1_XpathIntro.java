package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_XpathIntro {
    public static void main(String[] args) {
        /*
         * gehen Sie zur https://www.kitapyurdu.com/
         * klicken Sie - Tüm Kategoriler
         * suchen Sie - java
         * verifizieren Sie Suchergebnisinformation
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.kitapyurdu.com/");

        WebElement cookies = driver.findElement(By.id("cookiescript_accept"));
        cookies.click();

        WebElement category = driver.findElement(By.xpath("//a[@class='common-sprite allCategories']"));
        category.click();

        WebElement sucheElement = driver.findElement(By.xpath("//input[@id='search-input']"));
        sucheElement.sendKeys("java" + Keys.ENTER);



        WebElement actualErgebnis = driver.findElement(By.xpath("//h2"));
        // System.out.println("ergebnis.getText() = " + actualErgebnis.getText());
        String actual= actualErgebnis.getText();
        String expected = "54 ürün listelendi";

        if (actual.equals(expected)){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        driver.quit();


    }
}
