package com.eurotech.tests.tag_16;

import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _3_TestBrowserUtils extends TestBase {

    @Test
    public void test() {
        Driver.getDriver().get("https://www.google.com/");
        BrowserUtils.verifyTitle("Google");
        BrowserUtils.verifyURLContains("google.com");
    }


    @Test
    public void test2() {
        Driver.getDriver().get("https://demoqa.com/select-menu");
        WebElement colorDropDown = driver.findElement(By.cssSelector("select#oldSelectMenu"));
        List<String> colors = BrowserUtils.dropdownOptionsAsString(colorDropDown);
        for (String color : colors){
            System.out.println("color = " + color);
        }
    }

    @Test
    public void test3() {
        Driver.getDriver().get("https://practice.expandtesting.com/dynamic-loading/1");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        //implicitlyWait
        WebElement hello = driver.findElement(By.cssSelector("#finish>h4"));
        BrowserUtils.waitForVisibility(hello, 10);
        Assert.assertEquals(hello.getText(), "Hello World!");
    }

}
