package com.eurotech.tests.tag_09;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HtmlDropdown {
    /*
     * Gehen Sie https://demo.aspnetawesome.com/
     * Klicken Sie Fruits Dropdownbutton
     * Geben Sie alle Obstnamen aus
     * Klicken Sie das vierte Obst
     * Verifizieren Sie Banana
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
    }

    @Test
    public void test() {
        WebElement dropDownButton = driver.findElement(By.xpath("//button[@id='AllMeals-awed']"));
        dropDownButton.click();
        WebDriverFactory.wait(2);

        List<WebElement> obstElements = driver.findElements(By.cssSelector(".o-igit"));
        String actualObst = obstElements.get(3).getText();
        String expectedObst = "Banana";
        for (WebElement obst : obstElements){
            System.out.println("obst.getText() = " + obst.getText());
        }

        obstElements.get(3).click();
        Assert.assertEquals(actualObst,expectedObst);
    }

    @AfterMethod
    public void tearDown() {
        // driver.close();
    }
}
