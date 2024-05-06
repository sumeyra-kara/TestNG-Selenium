package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox {
    /*
     * Gehen Sie zur https://www.tutorialspoint.com/selenium/practice/check-box.php
     * Klicken Sie + button neben Main Level 1
     * Klicken Sie + button neben Sub Level 1
     * Wahlen Sie Sub Level 1 aus
     * Verifizieren Sie alle Last Level Checkboxes
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @Test
    public void test(){
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");

        //  Klicken Sie + button neben Main Level 1
        WebElement mainLevel1 = driver.findElement(By.xpath("//li[@id='bs_1']/span"));
        mainLevel1.click();
        WebDriverFactory.wait(2);

        //Klicken Sie + button neben Sub Level 1
        WebElement subLevel1 = driver.findElement(By.xpath("//li[@id='bf_1']/span"));
        subLevel1.click();
        WebDriverFactory.wait(2);

        // Wahlen Sie Sub Level 1 aus
        WebElement subLevelButton = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        subLevelButton.click();

        //Verifizieren Sie alle Last Level Checkboxes
       Assert.assertTrue(subLevelButton.isSelected());

        driver.close();

    }

}
