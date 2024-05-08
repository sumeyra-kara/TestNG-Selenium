package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
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
     *  * Schreiben Sie Hello World, nachdem Sie Prompt Alert geklickt haben  ??
     *  * Verifizieren Sie - You entered Hello World ????
     *  * Wechseln Sie "frames" Tab
     *  * Verifizieren Sie - This is a sample page
     *  * Wechseln Sie nestedframes Tab
     *  * Verifizieren Sie - Child Iframe
     *  * NOTE: Verwenden Sie die Methode getCurrentUrl() für Tabwechsel
     */

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        WebElement cookies = driver.findElement(By.xpath("//div[*='Alle ablehnen']"));
        cookies.click();
        String windowHandlegoogle = driver.getWindowHandle();
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/alerts','_blank')");
        Thread.sleep(2000);
        String windowHandleAlert ="";
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            if (!each.equals(windowHandlegoogle)){
                windowHandleAlert=each;
            }
        }


        ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/frames','_blank')");
        Thread.sleep(2000);

        Set<String> windowHandles2 = driver.getWindowHandles();
        String windowHandleiframe = "";
        for (String each2 : windowHandles2){
            if (!each2.equals(windowHandlegoogle) && !each2.equals(windowHandleAlert)){
                windowHandleiframe=each2;
            }
        }


        ((JavascriptExecutor)driver).executeScript("window.open('https://demoqa.com/nestedframes','_blank')");
        Thread.sleep(2000);
        Set<String> windowHandles3 = driver.getWindowHandles();
        String windowHandlenestedFrame = "";
        for (String each3 : windowHandles3){
            if (!each3.equals(windowHandlegoogle) && !each3.equals(windowHandleAlert) && !each3.equals(windowHandleiframe)){
                windowHandlenestedFrame=each3;
            }
        }

        System.out.println("******* " + driver.getWindowHandle());
        driver.switchTo().window(windowHandleAlert); // simdi artik alert tab'ina geldik....
        System.out.println("windowHandleAlert = " + windowHandleAlert);

        List<WebElement> clickMe = driver.findElements(By.xpath("//button[text()='Click me']"));
        for (WebElement button : clickMe){
            Thread.sleep(2000);
            button.click();
            Thread.sleep(7000);
            driver.switchTo().alert().accept();
        }

        Thread.sleep(2000);

        WebElement dorduncuPromptBox = driver.findElement(By.xpath("//button[@id='promtButton']"));
        dorduncuPromptBox.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Hello World");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();


        WebElement promptResult = driver.findElement(By.id("promptResult"));
        String actualHelloWorldYazisi = promptResult.getText();
        String expected = "You entered Hello World";
        Assert.assertEquals(actualHelloWorldYazisi,expected);

        driver.switchTo().window(windowHandleiframe); // simdi artik iframe tab'ina geldik....
        Thread.sleep(2000);

        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        Thread.sleep(1000);
        String expectedText="This is a sample page";
        String actualText =driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        driver.switchTo().window(windowHandlenestedFrame); // simdi artik nestedIframe tab'ina geldik....
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.id("frame1")));

        WebElement childIframe = driver.findElement(By.xpath("//*[@srcdoc='<p>Child Iframe</p>']"));
        String actualIcerik = childIframe.getAttribute("srcdoc");
        String expectedIcerik = "Child Iframe";
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        driver.switchTo().defaultContent();




    }
}
