package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_CssStartsWith {
    public static void main(String[] args) {
        /*
         * Gehen Sie zur https://ultimateqa.com/complicated-page
         * Schliessen Sie pop-up, wenn benötigt
         * Klicken Sie alle Buttons
         * Verifizieren Sie Überschrift - Skills Improved:
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ultimateqa.com/complicated-page");

        for (int i = 0; i < 12; i++) {
            String css = "a[class^='et_pb_button et_pb_button_" + i + " ']";
            WebElement button =driver.findElement(By.cssSelector(css));
            button.click();
            WebDriverFactory.wait(1);
        }

        WebElement skillsImproved = driver.findElement(By.cssSelector("#Skills_Improved"));
        System.out.println("skillsImproved.getText() = " + skillsImproved.getText());
        String actual = skillsImproved.getText();

        if (actual.equals("Skills Improved:")){
            System.out.println("Skills Improved Test Passed");
        } else {
            System.out.println("Skills Improved Test Failed");
        }


        String actualUberschrift = driver.getTitle();
        String expectedUberschrift = "Skills Improved:";

        if (actualUberschrift.equals(expectedUberschrift)){
            System.out.println("Title Test Passed");
        } else {
            System.out.println("Title Test Failed");
        }

        driver.close();
    }
}
