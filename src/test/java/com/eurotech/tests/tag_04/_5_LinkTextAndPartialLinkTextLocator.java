package com.eurotech.tests.tag_04;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_LinkTextAndPartialLinkTextLocator {

    public static void main(String[] args) {
        /*
         * gehen Sie zur - https://testpages.eviltester.com/styled/index.html
         * klicken Sie - Basic Web Page Example
         * verifizieren Sie Überschrift
         * kommen Sie zurück
         * klicken Sie - Element Attributes Examples
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://testpages.eviltester.com/styled/index.html");

        WebElement link = driver.findElement(By.partialLinkText("Basic Web Page Example"));
        link.click();

        WebDriverFactory.wait(3);

        String actualUberschrift= driver.getTitle();
        String expectedUberschrift ="Basic Web Page Title";

        if (actualUberschrift.equals(expectedUberschrift)){
            System.out.println("Uberschrift Test Passed");
        } else {
            System.out.println("Uberschrift Test Failed");
        }

        driver.navigate().back();
        WebDriverFactory.wait(3);

        WebElement elementAttributeElement = driver.findElement(By.linkText("Element Attributes Examples"));
        elementAttributeElement.click();

        String expectedH1Title = "Element Attributes Examples";
        WebElement actualTitle = driver.findElement(By.tagName("h1"));
        String actualTitleTest = actualTitle.getText();

        if (actualTitleTest.equals(expectedH1Title)){
            System.out.println("Title Test Passed");
        } else {
            System.out.println("Ttitle Test Failed");
        }


    }
}
