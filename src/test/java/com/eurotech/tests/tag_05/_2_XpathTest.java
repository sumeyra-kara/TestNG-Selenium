package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_XpathTest {
    public static void main(String[] args) {
        /*
         * gehen Sie zur https://practice.expandtesting.com/
         * klicken Sie - Add/Remove Elements
         * klicken Sie - Add ELement
         * kommen Sie zurück
         * verifizieren Sie den Text - Automation Testing Practice Website with demos and examples for UI and API using Cypress, Playwright, Selenium, WebdriverIO, Puppeteer, and Postman
         * verifizieren Sie die Erklarung - Dynamically adding and removing web elements
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.expandtesting.com/");

        WebElement addRemoveElement = driver.findElement(By.xpath("(//a[@class='my-link stretched-link'])[2]"));
        addRemoveElement.click();

        WebElement addElement = driver.findElement(By.xpath("//*[@class='btn btn-primary mt-3']"));
        //    //button[text()='Add Element'] ---
        addElement.click();



        driver.navigate().back();

        WebElement text = driver.findElement(By.xpath("//p[@style='color: #182B45;']"));
        // //p[contains(text(), 'for UI and API using Cypress')] ---- contains method ile olusturulabilir
        // //p[starts-with(text(), 'Automation Testing Practice Website')] --- starts-with methodu

        String actualText = text.getText();
        String expectedText = "Automation Testing Practice Website with demos and examples for UI and API using Cypress, Playwright, Selenium, WebdriverIO, Puppeteer, and Postman";

        if (actualText.equals(expectedText)){
            System.out.println("Text Test passed");
        } else
            System.out.println("Text Test Failed");

        WebElement erklarung = driver.findElement(By.xpath("(//p[@class='card-text'])[2]"));
        // //p[normalize-space(text())='Dynamically adding and removing web elements']
        String actualErklarung = erklarung.getText();
        String expectedErklarung = "Dynamically adding and removing web elements";

        if (actualErklarung.equals(expectedErklarung))
            System.out.println("Erklarung test Passed");
        else
            System.out.println("Erklarung Test Failed");

        driver.quit();


    }
}
