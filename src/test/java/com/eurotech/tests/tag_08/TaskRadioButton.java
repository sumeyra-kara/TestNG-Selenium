package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskRadioButton {
    /*
        https://demoqa.com/radio-button
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test() {
        driver.get("https://demoqa.com/radio-button");

        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", impressiveButton);
        //impressiveButton.click();
        Assert.assertTrue(impressiveButton.isSelected()); // ----?????
        Assert.assertTrue(impressiveButton.isEnabled());

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        Assert.assertTrue(yesButton.isEnabled());
        Assert.assertFalse(yesButton.isSelected());

        WebElement noButton = driver.findElement(By.xpath("//input[@id='noRadio']"));
       Assert.assertFalse(noButton.isEnabled()); // ????
        Assert.assertFalse(noButton.isSelected());

        driver.close();


    }
}
