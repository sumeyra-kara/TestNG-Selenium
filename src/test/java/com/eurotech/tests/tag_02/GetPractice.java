package com.eurotech.tests.tag_02;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class GetPractice {
    /*
     * gehen Sie https://demoqa.com/
     *testen Sie title
     *testen Sie URL
     *navigieren https://www.google.com/
     *erfrischen Seite
     *testen Sie title "Google"
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/");
        WebDriverFactory.wait(2);

        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitle = "demo";
        String actualTitle = driver.getTitle();


        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String exceptedUrl = "google";
        String actualUrl = driver.getCurrentUrl();

        if (exceptedUrl.equals(actualUrl)){
            System.out.println("url ist PASSED");
        } else {
            System.out.println("url ist FAILED");
        }

        driver.get("https://www.google.com/");
        WebDriverFactory.wait(2);

        driver.navigate().refresh();

        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitle2 = "google";
        String actualTitle2 = driver.getTitle();


        if (actualTitle2.contains(expectedTitle2)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }



    }


}
