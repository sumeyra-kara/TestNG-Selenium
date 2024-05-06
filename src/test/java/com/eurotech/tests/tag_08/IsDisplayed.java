package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class IsDisplayed {
    /*
     * Gehen Sie zur https://the-internet.herokuapp.com/dynamic_loading/1
     * Verifizieren Sie, dass "Hello World" nicht angezeigt(isDisplayed) ist
     * Klicken Sie Start
     * Verifizieren Sie, dass "Hello World" nicht angezeigt(isDisplayed) ist
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Verifizieren Sie, dass "Hello World" nicht angezeigt(isDisplayed) ist
        WebElement helloWorld = driver.findElement (By.xpath("//h4[text()='Hello World!']"));

        //Assert.assertFalse(pageSource.contains(expected));
        Assert.assertFalse(helloWorld.isDisplayed());
        WebDriverFactory.wait(3);

        // Klicken Sie Start
        WebElement start = driver.findElement(By.xpath("//div[@id='start']/button"));
        start.click();
        WebDriverFactory.wait(5);

        // Verifizieren Sie, dass "Hello World" nicht angezeigt(isDisplayed) ist
        //WebElement helloWorld = driver.findElement (By.xpath("//div[@id='finish']"));
        Assert.assertTrue(helloWorld.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }
}
