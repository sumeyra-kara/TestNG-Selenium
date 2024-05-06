package com.eurotech.tests.tag_12;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_JsExecutor {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }
    @Test
    public void sendKeysWithJs() {
        /*
         * Gehen Sie https://the-internet.herokuapp.com/dynamic_controls
         * Schreiben Sie Batch 16 is learning js executor
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textEdit = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String text = "Batch 16 is learning js executor";
        js.executeScript("arguments[0].setAttribute('value', '" + text +"')", textEdit);
    }

    @Test
    public void jSClicktest() {
        // Gehen Sie https://the-internet.herokuapp.com/dynamic_controls
        // clicken sie remove button
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement removeElement = driver.findElement(By.xpath("//button[text()='Remove']"));
        js.executeScript("arguments[0].click();",removeElement);
    }

    @Test
    public void scrollUpAndDown() {
        /**
         * Gehen Sie https://www.amazon.sg/
         * Scrollen Sie die Seite nach unten
         * Klicken Sie Poland
         */
         driver.get("https://www.amazon.sg/");
        JavascriptExecutor js = (JavascriptExecutor)driver;

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,500)", ""); //scroll down
            WebDriverFactory.wait(1);
        }
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-500)", ""); //scroll up
            WebDriverFactory.wait(1);
        }
        WebElement poland = driver.findElement(By.linkText("Poland"));
        poland.click();
    }

    @Test
    public void scrollToElementtest() throws InterruptedException {
        driver.get("https://www.amazon.sg/");
        WebElement poland = driver.findElement(By.linkText("Poland"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",poland);
        Thread.sleep(2);
        js.executeScript("arguments[0].click();",poland);


    }
    /*
    1. Adim : JavascriptExecutor kullanmak icin ilk adim olarak driver’imizi JavascriptExecutor’a cast edilir.
            JavascriptExecutor js = (JavascriptExecutor)driver;
    2. Adim : Kullanacagimiz WebElement locate edilir.
    3. Adim : Js driver ile executeScript method’unu calistiralim, icine parameter olarak ilgili script ve webelemnt’I yazalim
            js.executeScript("ilgili script", "webElementi");
         1***** Istenen Webelement’e kadar asagi inmek icin
         js.executeScript("arguments[0].scrollIntoView();",hedefWebelement);
         2***** Elemente click yapmak icin
         js.executeScript("arguments[0].click();",sellLinki);
         3***** Elemente Bir yazi göndermek icin
         js.executeScript("arguments[0].setAttribute('value', '" + text +"')", suchenButton);


     */
}
