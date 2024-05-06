package com.eurotech.tests.tag_11;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_Waits {
    /**
     * Gehen Sie https://practice.expandtesting.com/dynamic-loading/1
     * Klicken Sie Start Button
     * Verifizieren Sie Hello World!
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.expandtesting.com/dynamic-loading/1");
    }
    @AfterMethod
    public void tearDown() {
         driver.quit();
    }
    @Test
    public void threadSleepTest() throws InterruptedException {
        WebElement startElement = driver.findElement(By.xpath("//button[text()='Start']"));
        startElement.click();

        Thread.sleep(6000);
        WebElement helloWorldElement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorldElement.isDisplayed());
    }

    @Test
    public void testName() {
        WebElement startElement = driver.findElement(By.xpath("//button[text()='Start']"));
        startElement.click();
        WebElement helloWorldElement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait explicitlyWait = new WebDriverWait(driver,20);
        explicitlyWait.until(ExpectedConditions.visibilityOf(helloWorldElement));
        Assert.assertTrue(helloWorldElement.isDisplayed());
    }
}
