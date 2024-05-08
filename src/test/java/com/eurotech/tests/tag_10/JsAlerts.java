package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JsAlerts {
    /**
     * Gehen Sie zur https://the-internet.herokuapp.com/javascript_alerts
     * Klicken Sie Click for JS Alert und akzeptieren
     * Klicken Sie Click for Js Confirm und ablehnen
     * Klicken Sie Click for JS Prompt und schreiben - I have clicked
     * Verifizieren Sie Result Message - I have clicked
     */
    @Test
    public void jSAlertTest() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        WebDriverFactory.wait(2);
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmButton.click();
        WebDriverFactory.wait(2);
        alert.dismiss();

        WebElement jspromptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jspromptButton.click();
        WebDriverFactory.wait(2);
        alert.sendKeys("I have clicked");
        alert.accept();
        driver.quit();








    }
}
