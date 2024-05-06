package com.eurotech.tests.tag_12;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _4_Task {
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
    public void actionClassTest() {
        /**
         * Gehen Sie https://webdriveruniversity.com/Actions/index.html
         * Ziehen Sie "DRAG ME TO MY TARGET!" und legen Sie "DROP HERE!" ab
         * Doppelklicken Sie "Double Click Me!"
         * Schweben Sie über "Hover Over Me First!", "Hover Over Me Second!", "Hover Over Me Third!"
         * Klicken Sie "Link 1" nach alle Hover Over Buttons
         */
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement dragMeElement = driver.findElement(By.xpath("//b[text()='DRAG ME TO MY TARGET!']"));
        WebElement dropHereElement = driver.findElement(By.xpath("//b[text()='DROP HERE!']"));
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();

        WebElement dobleClickMe = driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(dobleClickMe).perform();

        WebElement hoverOverFirst = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        WebElement hoverOverSecond = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        WebElement hoverOverThird = driver.findElement(By.xpath("//button[text()='Hover Over Me Third!']"));

        actions.moveToElement(hoverOverFirst).perform();
        WebElement link1 = driver.findElement(By.xpath("(//div[@class='dropdown-content']//a)[1]"));
        actions.click(link1).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        actions.moveToElement(hoverOverSecond).perform();
        WebElement link2 = driver.findElement(By.xpath("(//div[@class='dropdown-content']//a)[2]"));
        actions.click(link2).perform();
        alert.accept();

        actions.moveToElement(hoverOverThird).perform();
        WebElement link3 = driver.findElement(By.xpath("(//div[@class='dropdown-content']//a)[3]"));
        actions.click(link3).perform();
        alert.accept();
    }
    @Test
    public void uploadTest() {
       /**
        * Gehen Sie https://demoqa.com/upload-download
        * Hochladen Sie eine Datei von Projekt
        */
       driver.get("https://demoqa.com/upload-download");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath); // C:\Users\User\IdeaProjects\TestNG-Selenium

        String filePath = "src/test/resources/Microsoft Word-Dokument (neu).docx";
        String fullPath = projectPath + "/"+filePath;
        System.out.println("fullPath = " + fullPath);

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        uploadFile.sendKeys(fullPath);
    }

    @Test
    public void jScriptTest() {
        /**
         * Benutzen Sie JavaScriptExecutor für jede Schritt
         * Gehen Sie https://www.amazon.sg/
         * Suchen Sie javascript
         * Gehen Sie das letzte Produkt und klicken
         * Klicken Sie Add to Cart
         * Gehen Sie den Warenkorb
         * Verifizieren Sie Cart Subtotal
         */
        driver.get("https://www.amazon.sg/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement suchenButton = driver.findElement(By.id("twotabsearchtextbox"));
        js.executeScript("arguments[0].click();",suchenButton);

        String text = "javascript";
        js.executeScript("arguments[0].setAttribute('value', '" + text +"')", suchenButton);

        WebElement suchenElement = driver.findElement(By.id("nav-search-submit-button"));
        js.executeScript("arguments[0].click();",suchenElement);

        WebElement letzteProduct = driver.findElement(By.xpath("//span[text()='Data Structures and Algorithms in Javascript']"));
        js.executeScript("arguments[0].scrollIntoView();",letzteProduct);
        js.executeScript("arguments[0].click();",letzteProduct);

        /*
        Sayfanin sonuna su sekilde de gidilebilir (action class ile)
        actions.sendKeys(Keys.END).perform();
         */

        WebElement addCartButton = driver.findElement(By.id("add-to-cart-button"));
        js.executeScript("arguments[0].click();",addCartButton);

        WebElement warenkorb = driver.findElement(By.id("nav-cart-count"));
        js.executeScript("arguments[0].click();",warenkorb);

        WebElement subTotal = driver.findElement(By.id("sc-subtotal-label-buybox"));
        System.out.println("subTotal.getText() = " + subTotal.getText());
        String actual = subTotal.getText();
        String expected = "Subtotal (1 item):";
        Assert.assertTrue(actual.contains(expected));

    }
}
