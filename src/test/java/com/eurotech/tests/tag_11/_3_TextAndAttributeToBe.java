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

public class _3_TextAndAttributeToBe {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void attribute1() {
        /*
         * Gehen Sie https://testpages.eviltester.com/styled/progress-bars-sync.html
         * Warten, bis "Task 3" geladen ist
         * Verifizieren Sie, dass "Task 3" 100% ist.
         * Verifizieren Sie Stopped
         */
        driver.get("https://testpages.eviltester.com/styled/progress-bars-sync.html");
        WebElement task3 = driver.findElement(By.id("progressbar2"));


        wait.until(ExpectedConditions.attributeToBe(task3,"value","100"));
        String value = task3.getAttribute("value");
        Assert.assertEquals(value, "100");
    }

    @Test
    public void testToBe() {
        //driver.get("https://testpages.eviltester.com/styled/progress-bars-sync.html");
        WebElement stopped = driver.findElement(By.xpath("//p[text()='Stopped']"));
        wait.until(ExpectedConditions.visibilityOf(stopped));
        Assert.assertEquals(stopped.getText(),"Stopped");
    }
}