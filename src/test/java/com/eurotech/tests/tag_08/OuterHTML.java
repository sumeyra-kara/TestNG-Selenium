package com.eurotech.tests.tag_08;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OuterHTML {
    /*
     * Gehen Sie zur https://demoqa.com/text-box
     * Verifizieren Sie outerHtml
     */

    @Test
    public void outerTest() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        WebElement userName = driver.findElement(By.cssSelector("#userName"));
        System.out.println("userName.getAttribute(\"autocomplete\") = " + userName.getAttribute("autocomplete"));

        System.out.println("userName.getAttribute(\"outerHTML\") = " + userName.getAttribute("outerHTML"));

        System.out.println("userName.getAttribute(\"klass\") = " + userName.getAttribute("klass")); // eger yanlis yazilirsa null verir
        System.out.println("userName.getAttribute(\"klass\") = " + userName.getAttribute("class")); // dogru yazildiginda dogrusunu verir
    }
}
