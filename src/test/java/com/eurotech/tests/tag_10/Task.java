package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Task {

    /**
     *  * Gehen Sie zur https://www.google.com/
     *  * Öffnen Sie diese drei Seite
     *  *         ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/alerts','_blank')");
     *  *         ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/frames','_blank')");
     *  *         ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/nestedframes','_blank')");
     *  * Wechseln "alerts" Tab
     *  * Klicken Sie alle "Click me" Buttons und benutzen Sie Alert methods
     *  * Schreiben Sie Hello World, nachdem Sie Prompt Alert geklickt haben
     *  * Verifizieren Sie - You entered Hello World
     *  * Wechseln Sie "frames" Tab
     *  * Verifizieren Sie - This is a sample page
     *  * Wechseln Sie nestedframes Tab
     *  * Verifizieren Sie - Child Iframe
     *  * NOTE: Verwenden Sie die Methode getCurrentUrl() für Tabwechsel
     */


    @Test
    public void test() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");

        ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/alerts','_blank')");
        ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/frames','_blank')");
        ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/nestedframes','_blank')");



    }
}
