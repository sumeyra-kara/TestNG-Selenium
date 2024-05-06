package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class NestedFrames {
    /*
     * Gehen Sie zur https://the-internet.herokuapp.com/nested_frames
     * Verifizieren Sie MIDDLE
     * Verifizieren Sie BOTTOM
     */
    @Test
    public void nestedFrames() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebDriverFactory.wait(1);

        driver.switchTo().frame("frame-top");
        WebDriverFactory.wait(2);
        driver.switchTo().frame("frame-middle");
        WebDriverFactory.wait(2);
        String actualMiddle = driver.findElement(By.cssSelector("#content")).getText();
        String expectedMiddle = "MIDDLE";
        Assert.assertEquals(actualMiddle,expectedMiddle);

        /*
        Wir müssen unsere frames eins zu eins wechseln
         */
        //driver.switchTo().parentFrame(); // wir können nur vorherige frame gehen
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent(); // wir können haupt html eingehen

        driver.switchTo().frame("frame-bottom");
        WebElement body = driver.findElement(By.xpath("//body"));
        String button = body.getText();
        String expectedButton = "BOTTOM";
        Assert.assertEquals(button,expectedButton);
        System.out.println("button = " + button);
        driver.quit();
    }
}
