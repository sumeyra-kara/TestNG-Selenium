package com.eurotech.tests.tag_09;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiSelectDropDown {
    /*
     * Gehen Sie zur https://mdbootstrap.com/docs/standard/extended/multiselect/
     * Machen Sie one - deselected
     * Machen Sie Two - selected
     * Machen Sie Three - selected
     * Geben Sie alle gewahlte Optionen
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://mdbootstrap.com/docs/standard/extended/multiselect/");
    }

    @Test
    public void multiSelectTest() {
        WebDriverFactory.wait(3);
        driver.findElement(By.xpath("//button[@id='accept_cookies_btn']")).click();
        WebDriverFactory.wait(4);

       WebElement dropdown = driver.findElement(By.xpath("//input[@class='form-control select-input active']/../.."));
       dropdown.click();

       WebElement one =driver.findElement(By.xpath("//span[text()='One']/input"));
       one.click();
       WebDriverFactory.wait(2);

       WebElement two =driver.findElement(By.xpath("//span[text()='Two']/input"));
       two.click();
        WebDriverFactory.wait(2);


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
