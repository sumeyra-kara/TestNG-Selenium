package com.eurotech.tests.tag_07;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MultipleTest {
    /**
     * Gehen Sie zur https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
     * Geben Sie username ein - Admin
     * Geben Sie password ein - admin123
     * Drücken Sie Enter Taste
     * Klicken Sie Admin
     * Verifizieren Sie "Benutzerverwaltung" oben auf der Seite
     */
    /**
     * Gehen Sie zur https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
     * Geben Sie username ein - Admin
     * Geben Sie password ein - admin123
     * Drücken Sie Enter Taste
     * Klicken Sie Performance
     * Verifizieren Sie "Manage Reviews" oben auf der Seite
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("admin123", Keys.ENTER);
    }
    @Test @Ignore
    public void adminTest(){
        WebElement adminButton = driver.findElement(By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']"));
        adminButton.click();
        String adminHeader = driver.findElement(By.xpath("//h6[text()='User Management']")).getText();
        Assert.assertEquals(adminHeader,"User Management");
    }

    @Test
    public void performanceTest(){
        WebElement performanceButton = driver.findElement(By.xpath("//a[@href='/web/index.php/performance/viewPerformanceModule']"));
        performanceButton.click();
        String manageReviews = driver.findElement(By.xpath("//h6[text()='Manage Reviews']")).getText();
        Assert.assertEquals(manageReviews,"Manage Reviews");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
