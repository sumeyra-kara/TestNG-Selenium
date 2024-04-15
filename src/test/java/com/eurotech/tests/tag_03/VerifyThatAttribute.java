package com.eurotech.tests.tag_03;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatAttribute {

    public static void main(String[] args) {
        /*
         * gehen Sie zur "https://testpages.eviltester.com/styled/attributes-test.html"
         * Identifizieren Sie domattributes Element
         * nehmen Sie alle Attributes dieses Elements
         * Verifiziren Sie, dass diese Attributevalues richtig sind
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://testpages.eviltester.com/styled/attributes-test.html");


        WebElement domattribute = driver.findElement(By.id("domattributes"));

        String idValue=domattribute.getAttribute("id");
        System.out.println("idValue = " + idValue); // domattributes

        String customAttributeValue = domattribute.getAttribute("custom-attrib");
        System.out.println("customAttributeValue = " + customAttributeValue); // attrib in source at load

        String attributeText = domattribute.getText();
        System.out.println("attributeText = " + attributeText); //  This paragraph has attributes

        String expectedIdAttributeValue = "domattributes";
        String actualIdAttributeValue = idValue;

        if (expectedIdAttributeValue.equals(actualIdAttributeValue)){
            System.out.println("Id Attribute Passed");
        } else {
            System.out.println("Id Attribute failed");
        }


        String expectedcustomAttributeValue = "attrib in source at load";
        String actualCustomAttributeValue = customAttributeValue;

        if (expectedcustomAttributeValue.equals(actualCustomAttributeValue)){
            System.out.println("Custom Attribute Passed");
        } else {
            System.out.println("Custom Attribute Failed");
        }


        String expectedAttributeTextValue = "This paragraph has attributes";
        String actualAttributTextValue = attributeText;

        if (expectedAttributeTextValue.equals(actualAttributTextValue)){
            System.out.println("Text Attribute Passed");
        } else {
            System.out.println("Text Attribute Failed");
        }

        //driver.quit();


    }
}
