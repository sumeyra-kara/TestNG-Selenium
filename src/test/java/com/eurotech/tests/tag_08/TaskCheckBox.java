package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskCheckBox {
    /*
    https://demoqa.com/checkbox
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void checkBoxTest() {

        driver.get("https://demoqa.com/checkbox");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        WebElement homeElement = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        homeElement.click();
        WebDriverFactory.wait(2);

        WebElement documentsElement = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        documentsElement.click();
        WebDriverFactory.wait(2);

        WebElement workSpaceElement = driver.findElement(By.xpath("(//button[@type='button'])[7]"));
        workSpaceElement.click();
        WebDriverFactory.wait(2);

        WebElement erste = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[5]"));
        //WebElement erste = driver.findElement(By.xpath("//input[@id='tree-node-react']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", erste);
        erste.click();
        WebDriverFactory.wait(4);


        //Assert.assertTrue(erste.isSelected());// ;--???



    }



}
