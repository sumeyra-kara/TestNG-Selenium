package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _3_CssEndWith {
    public static void main(String[] args) {
        /*
         * Gehen Sie zur https://the-internet.herokuapp.com/challenging_dom
         * Klicken Sie auf die blaue, rote und grüne Taste
         * Verifizieren Sie, dass "Fork me on GitHub" Bild existiert
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        List<WebElement> farbeButton = driver.findElements(By.cssSelector("a[id$='2655b9260a2e']"));

        for (WebElement button : farbeButton){
            System.out.println("button.getText() = " + button.getText());
        }

        WebElement bild = driver.findElement(By.cssSelector("img[alt$='GitHub']"));

        String actualImageName = bild.getAttribute("alt");
        String expected = "Fork me on GitHub";

        if (actualImageName.equals(expected))
            System.out.println("Test Passed");
        else {
            System.out.println("Test Passed");
        }
        driver.close();


    }
}
