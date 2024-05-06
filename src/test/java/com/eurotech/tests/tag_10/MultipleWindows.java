package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    /**
     * Gehen Sie zur https://qa-practice.netlify.app/tab
     * Klicken Sie neue Tab Button
     * Wechseln zum neu geöffneten Tab
     * Öffnen Sie drei neue Tab

     * Wechseln zu Linkedin Tab
     * Verifizieren Sie Page Title
     */

    @Test
    public void MultipleWindow() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa-practice.netlify.app/tab");
        WebElement newTabBtn = driver.findElement(By.id("newTabBtn"));
        newTabBtn.click();

        String aktuelleTab = driver.getWindowHandle();
        System.out.println("aktuelle Tab = " + aktuelleTab); // aktuelle Tab

        Set<String> windowHandles = driver.getWindowHandles();
        for (String neueTab : windowHandles){
            if (!neueTab.equals(aktuelleTab)){
                driver.switchTo().window(neueTab);
            }
        }

        String tableText = driver.findElement(By.tagName("h2")).getText();
        System.out.println("tableText = " + tableText);
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.google.com','_blank')");
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.facebook.com','_blank')");
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.linkedin.com','_blank')");

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows){
            driver.switchTo().window(window);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            if (driver.getTitle().equals("LinkedIn: Einloggen oder anmelden")){
                break;
            }
        }


    }
}
