package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
    /**
     * Gehen Sie zur https://qa-practice.netlify.app/radiobuttons.html
     * Verifizieren Sie Radio button 3 "isSelected"
     /**
     * Gehen Sie zur https://qa-practice.netlify.app/radiobuttons.html
     * Verifizieren Sie Radio button 4 "isEnabled"
     */

   WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa-practice.netlify.app/radiobuttons.html");
    }
    public WebElement getRadioButton(int index){
        String xpath = "//input[@id='radio-button"+ index +"']";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public void radioButton3Test() {
        Assert.assertTrue(getRadioButton(3).isSelected());
    }

    @Test
    public void radioButton4(){
        Assert.assertFalse(getRadioButton(4).isEnabled());
    }

    @Test
    public void radioButton1(){
        getRadioButton(1).click();
        Assert.assertTrue(getRadioButton(1).isSelected());
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
