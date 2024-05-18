package com.eurotech.tests.tag_19;

import com.eurotech.pages.StalePage;
import com.eurotech.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _StaleElementException extends TestBase {
    /*
     * Gehen Sie https://freecrm.com/
     * Klicken Sie Login button
     * Geben Sie email ein
     * Geben Sie password ein
     * Erfrischen Sie die Seite
     * Geben Sie email ein
     * Geben Sie password ein
     */
    StalePage stalePage = new StalePage();
    @Test
    public void staleElementReferenceExceptionTest() {
        driver.get("https://freecrm.com/");
        WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginButton.click();

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("Selenium@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("selenium");

        driver.navigate().refresh();

        try { // exception almamak icin try catch olusturuyoruz
            email.sendKeys("Selenium@gmail.com");
        } catch (StaleElementReferenceException e) {
           email = driver.findElement(By.xpath("//input[@name='email']"));
            email.sendKeys("Selenium@gmail.com");
            password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("selenium");
        }
    }

    @Test
    public void staleElementHandleWithPOM() { // pom ile yapinca exception almiyoruz
        driver.get("https://freecrm.com/");
        stalePage.loginButton.click();
        stalePage.email.sendKeys("Selenium@gmail.com");
        stalePage.password.sendKeys("selenium");
        driver.navigate().refresh();
        stalePage.email.sendKeys("Selenium@gmail.com");
        stalePage.password.sendKeys("selenium");
    }
}
