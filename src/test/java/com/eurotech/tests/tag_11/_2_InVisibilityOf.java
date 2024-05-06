package com.eurotech.tests.tag_11;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_InVisibilityOf {
    /**
     * Gehen Sie https://qa-practice.netlify.app/loader
     * Warten, bis das Laden beendet ist
     * Verifizieren Sie Tada!
     */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver,15);
    }
    @AfterMethod
    public void tearDown() {
      //  driver.quit();
    }

    @Test
    public void invisibilityOfTest() {
        driver.get("https://qa-practice.netlify.app/loader");
        WebElement loadindElement = driver.findElement(By.xpath("//div[@id='loader']"));
        WebElement tada = driver.findElement(By.xpath("//h2[text()='Tada!']"));
        wait.until(ExpectedConditions.invisibilityOf(loadindElement));
        Assert.assertEquals(tada.getText(),"Tada!");
    }
}
