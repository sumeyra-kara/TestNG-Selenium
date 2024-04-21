package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_Task5 {
    public static void main(String[] args) {
        /*
        Locator XPATH PRACTICES
        1.  Öffnen Sie den Chrome-Browser
        2.  Gehen Sie zur https://the-internet.herokuapp.com/forgot_password Links
        3.  Identifizieren Sie alle WebElemente auf der Seite nur mit dem XPATH-Locator
        a. “Forgot password” header
        b. “E-mail” text
        c. E-mail input box
        d. “Retrieve password” button
        4.  den Text von a, b, d ausdrucken und eine E-Mail an c senden.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPassword = driver.findElement(By.xpath("//h2"));
        System.out.println("forgotPassword.getText() = " + forgotPassword.getText());

        WebElement eMail= driver.findElement(By.xpath("//label[@for]"));
        System.out.println("eMail.getText() = " + eMail.getText());

        WebElement eMailBox = driver.findElement(By.xpath("//input[@name='email']"));
        eMailBox.sendKeys("adada@gmail.com");
        WebDriverFactory.wait(3);
        eMailBox.click();

        WebElement retrivePasswordBox = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        System.out.println("retrivePasswordBox.getText() = " + retrivePasswordBox.getText());

        driver.close();


    }
}
