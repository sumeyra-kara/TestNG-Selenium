package com.eurotech.tests.tag_12;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ActionClass {
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
    public void hoverOverTest() {
        /**
         * Gehen Sie https://qa-practice.netlify.app/mouse-hover
         * Schweben Sie über den Text
         * Verifizieren Sie HOVERED
         * Schweben Sie über Hover over Button
         * Verifizieren Sie I am shown when someone hovers over the text above.
         */
        driver.get("https://qa-practice.netlify.app/mouse-hover");
        WebElement hoveredText = driver.findElement(By.id("demo"));
        actions.moveToElement(hoveredText).perform();
        Assert.assertEquals(hoveredText.getText(),"HOVERED");
        WebElement hoverOverButton = driver.findElement(By.id("button-hover-over"));
        actions.moveToElement(hoverOverButton).perform();
        String hideText = driver.findElement(By.className("hide")).getText();
        Assert.assertEquals(hideText,"I am shown when someone hovers over the text above.");
    }
    @Test
    public void clickTest() {
        /**
         * Gehen Sie https://demoqa.com/buttons
         * Doppelklicken Sie auf Double Click Me
         * Verifiziren Sie You have done a double click
         * Klicken Sie mit der Rechts-Taste auf Right Click Me
         * Verisizieren Sie You have done a right click
         */

        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String expectedDoubleClickMessage = "You have done a double click";
        Assert.assertEquals(doubleClickMessage.getText(),expectedDoubleClickMessage);

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String expectedRightClickMessage = "You have done a right click";
        Assert.assertEquals(rightClickMessage.getText(),expectedRightClickMessage);
    }

    @Test
    public void dragAndDropTest() {
        /*
         * Gehen Sie https://testpages.eviltester.com/styled/drag-drop-javascript.html
         * Ziehen Sie erste "Drag me" und legen Sie sie auf erste "Drop here" ab.
         * Verifizieren Sie Dropped!
         * Ziehen Sie zweite "Drag me", warten Sie auf 3 Sekunde und legen Sie sie auf zweite "Drop here" ab
         * Verifizieren Sie Dropped!
         */
        driver.get("https://testpages.eviltester.com/styled/drag-drop-javascript.html");
        WebElement draggable1 = driver.findElement(By.id("draggable1"));
        WebElement droppable1 = driver.findElement(By.id("droppable1"));
        actions.dragAndDrop(draggable1,droppable1).perform();

        Assert.assertEquals(droppable1.getText(),"Dropped!");


        WebElement draggable2 = driver.findElement(By.id("draggable2"));
        WebElement droppable2 = driver.findElement(By.id("droppable2"));

        actions.clickAndHold(draggable2).pause(3000).release(droppable2).perform();
        Assert.assertEquals(droppable2.getText(),"Dropped!");



    }
}
