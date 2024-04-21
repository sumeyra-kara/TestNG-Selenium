package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_CssSelectorIntro {
    public static void main(String[] args) {
      /*
       * Gehen Sie zur https://www.idefix.com/
       * Schliessen Sie pop-up, wenn benötigt
       * Suchbegriff "java" eingeben
       * Klicken Sie auf die Suchtaste
       * Klicken Sie auf das erste Produkt
       * Verifizieren Sie den Namen des Autors
       */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.idefix.com/");

        WebElement cookies = driver.findElement(By.xpath("//div[@class='dn-slide-buttons horizontal']/button"));
        cookies.click();

        WebElement javaElement = driver.findElement(By.cssSelector("input#headerSearch-d"));
        javaElement.sendKeys("java");


        WebElement suchTaste = driver.findElement(By.cssSelector(".flex.absolute.inset-y-0.right-3.items-center.cursor-pointer.z-50"));
        suchTaste.click();
        WebDriverFactory.wait(2);

        WebElement ersteProduct = driver.findElement(By.cssSelector(".w-full.h-full.absolute.top-0.left-0.bottom-0.right-0.z-20.cursor-pointer"));
        WebDriverFactory.wait(2);
        ersteProduct.click();

        WebElement autorElement = driver.findElement(By.cssSelector("span[class='text-[1.375rem] leading-[1.875rem] cursor-pointer']"));
        String actualAutorElement = autorElement.getText();
        String expectedAutorElement = "A. Murat Özbayoğlu";

        if (actualAutorElement.equals(expectedAutorElement))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        WebDriverFactory.wait(2);

        driver.quit();


    }
}
