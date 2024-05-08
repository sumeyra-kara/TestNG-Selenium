package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Iframe {
    /**
     * Gehen Sie zur https://the-internet.herokuapp.com/iframe
     * Schreiben Sie innerhalb Html Editor - Hello World
     * Verifizieren Sie Hello World
     */

    @Test
    public void iFrameTest() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr"))); // locater ile
       // driver.switchTo().frame(0); // indeks ile
       // driver.switchTo().frame("mce_0_ifr"); // id oder name ile

        WebElement content = driver.findElement(By.id("tinymce"));
        content.clear();
        content.sendKeys("Hello World");
        driver.quit();
    }
}
