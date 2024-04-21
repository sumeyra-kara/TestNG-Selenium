package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _5_CssParentToChild {
    public static void main(String[] args) {
        /*
         * Gehen Sie zur https://rahulshettyacademy.com/AutomationPractice/
         * Klicken Sie alle Radio Buttons
         * Verifizieren Sie die Überschrift der Radiobuttons
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> buttonClick = driver.findElements(By.cssSelector("#radio-btn-example>fieldset>label>input"));
        for (WebElement button:buttonClick){
            button.click();
            WebDriverFactory.wait(1);
        }

        WebElement uberschriftDerRadioButtons = driver.findElement(By.cssSelector("#radio-btn-example>fieldset>legend"));

        System.out.println("uberschriftDerRadioButtons.getText() = " + uberschriftDerRadioButtons.getText());

        String actualUberschrift = uberschriftDerRadioButtons.getText();
        String expectedUberschrift = "Radio Button Example";

        if (actualUberschrift.equals(expectedUberschrift)){
            System.out.println("Test Passed");
        } else
            System.out.println("Test Failed");

        driver.close();


    }
}
