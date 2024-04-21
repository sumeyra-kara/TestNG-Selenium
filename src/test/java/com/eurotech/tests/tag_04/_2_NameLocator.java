package com.eurotech.tests.tag_04;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_NameLocator {
    public static void main(String[] args) {
        /*
         * gehen Sie zur - https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
         * füllen Sie username aus - Admin
         * füllen Sie password aus - admin123
         * klicken Sie Enter Taste
         * verifizieren Sie, dass sich die URL geändert hat - https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverFactory.wait(5);

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement buttonEnter = driver.findElement(By.tagName("button"));
        buttonEnter.click();
        // password.sendKeys("admin123" + Keys.ENTER); bunlar yerine bu da yapilabilir



        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Url Test passed");
        } else {
            System.out.println("Url test failed");
        }

        driver.quit();




    }
}
