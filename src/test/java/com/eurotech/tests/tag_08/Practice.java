package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Practice {
    /*
     * Gehen Sie zur https://www.ironspider.ca/
     * Klicken Sie Web Page Forms
     * Klicken Sie Checkboxes & Radio Buttons
     * Wahlen Sie alle Farben aus
     * Verifizieren Sie alle Farben - isSelected
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test() {
        driver.get("https://www.ironspider.ca/");
        WebElement webPageForms = driver.findElement(By.xpath("//div[text()='Web Page Forms']"));
        webPageForms.click();

        WebElement button = driver.findElement(By.xpath("//a[@href='forms/checkradio.htm']"));
        button.click();
        WebDriverFactory.wait(3);


        List<WebElement> elements = driver.findElements(By.xpath("//input[@name='color']"));
        for (WebElement color : elements){
            color.click();
            Assert.assertTrue(color.isSelected());
        }



    }
}
