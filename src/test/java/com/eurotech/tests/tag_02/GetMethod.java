package com.eurotech.tests.tag_02;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import javax.security.auth.login.FailedLoginException;

public class GetMethod {
    public static void main(String[] args) {

        WebDriver driver =WebDriverFactory.getDriver("chrome");
        driver.get("https://eurotechstudy.com/en");
        WebDriverFactory.wait(2);

        String expectedTitle = "Online IT Bootcamp";
        String actualTitle = driver.getTitle();

        System.out.println("driver.getTitle() = " + driver.getTitle()); // Online IT Bootcamp

        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle)); // true

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }


        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl()); // https://eurotechstudy.com/en

        String exceptedUrl = "https://eurotechstudy.com/en";
        String actualUrl = driver.getCurrentUrl();
        if (exceptedUrl.equals(actualUrl)){ // actualUrl.contains(exceptedUrl) olarak da bakilabilir
            System.out.println("url ist PASSED");
        } else {
            System.out.println("url ist FAILED");
        }

        // System.out.println("exceptedUrl.equals(actualUrl) = " + exceptedUrl.equals(actualUrl));     // true

       // System.out.println("driver.getPageSource() = " + driver.getPageSource()); --- gidilen sayfanin kaynak kodlarini döndürür


        driver.close();

    }
}
