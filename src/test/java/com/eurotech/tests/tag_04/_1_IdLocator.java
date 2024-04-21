package com.eurotech.tests.tag_04;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_IdLocator {
    public static void main(String[] args) {
        /*
         * gehen Sie zur - http://www.automationpractice.pl/index.php
         * suchen Sie - black
         * klicken Sie auf die schwarze Farbe des ersten Produkts
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.automationpractice.pl/index.php");

        WebElement search = driver.findElement(By.id("search_query_top"));
        search.sendKeys("black");

        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
        WebDriverFactory.wait(3);

        WebElement ersteProduct = driver.findElement(By.id("color_7"));
        ersteProduct.click();

        driver.close();






    }
}
