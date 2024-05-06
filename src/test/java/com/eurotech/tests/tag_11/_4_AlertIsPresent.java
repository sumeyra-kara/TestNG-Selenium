package com.eurotech.tests.tag_11;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _4_AlertIsPresent {
    /**
     * Gehen Sie https://demoqa.com/alerts
     * Klicken Sie zweite Alert Button
     * Akzeptieren Sie Alert
     */

    WebDriver driver;
    Wait<WebDriver> wait;
    //WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.expandtesting.com/dynamic-loading/1");
        wait = new WebDriverWait(driver,20);
    }
    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
    @Test
    public void alertIsPresentTest() {
        driver.get("https://demoqa.com/alerts");
        WebElement zweiteButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(zweiteButton);
        zweiteButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("This alert appeared after 5 seconds"));
        alert.accept();



    }
}
