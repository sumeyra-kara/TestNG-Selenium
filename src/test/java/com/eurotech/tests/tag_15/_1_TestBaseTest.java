package com.eurotech.tests.tag_15;

import com.eurotech.tests.TestBase;
import com.eurotech.utility.ConfigReader;
import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class _1_TestBaseTest extends TestBase {

    @Test
    public void test1() {
        driver.get("https://www.google.com/");
        WebElement searchButton = driver.findElement(By.name("q"));
        searchButton.sendKeys("selenium" + Keys.ENTER);
        WebDriver driver2 = Driver.getDriver();
        driver2.findElement(By.xpath("//h3.='Selenium']")).click();

    }
}
