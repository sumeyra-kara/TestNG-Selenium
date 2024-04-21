package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_CssContainsAndSibling {
    public static void main(String[] args) {
        /*
         * Gehen Sie zur https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
         * Verifizieren Sie den Namen des Bildes oben auf der Seite - company-branding
         * Verifizieren Sie Unternehmen Informationen
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement bildElement = driver.findElement(By.cssSelector("img[src*='branding']"));
        String actualBildElement = bildElement.getAttribute("alt");
        System.out.println("actualBildElement = " + actualBildElement);
        String expectedBildElement = "company-branding";

        if (actualBildElement.equals(expectedBildElement))
            System.out.println("Name des Bildes Test Passed");
        else
            System.out.println("Name des Bildes Test Failed");

        WebElement unternehmenInformation1 = driver.findElement(By.cssSelector("p[class*='oxd-text oxd-text--p orangehrm-copyright']"));
        WebElement unternehmenInformation2 = driver.findElement(By.cssSelector("p[class*='oxd-text oxd-text--p orangehrm-copyright']~p"));

        String actual1 = unternehmenInformation1.getText();
        String actual2 = unternehmenInformation2.getText();


        String expected1 = "OrangeHRM OS 5.6.1";
        String expected2 = "© 2005 - 2024 OrangeHRM, Inc. All rights reserved.";

        if (actual1.equals(expected1)){
            System.out.println(actual1 + " Test Passed");
        } else {
            System.out.println(actual1 + " Test Failed");
        }


        if (actual2.equals(expected2)){
            System.out.println(actual2 + " : Test Passed");
        } else {
            System.out.println(actual2 + " : Test Failed");
        }

        driver.close();



    }
}
