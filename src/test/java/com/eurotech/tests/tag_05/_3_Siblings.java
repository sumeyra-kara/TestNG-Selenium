package com.eurotech.tests.tag_05;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _3_Siblings {
    public static void main(String[] args) {
        /*
         * gehen Sie zur https://testautomationpractice.blogspot.com/
         * klicken Sie auf - Male
         * verifizieren Sie, dass Sunday existiert
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://testautomationpractice.blogspot.com/");


        WebElement maleBox = driver.findElement(By.xpath("//div[@class='form-group']/following-sibling::div[2]/div/input"));
        maleBox.click();

        WebElement sundayBox = driver.findElement(By.xpath("//div[@class='form-group']/following-sibling::div[3]/div/label"));

        String actualSundayTest = sundayBox.getText();

        if (actualSundayTest.equals("Sunday"))
            System.out.println("Sunday Test Passed");
        else
            System.out.println("Sunday Test Failed");


        // bütün elementleri almak icin -- findElements methodu kullaniliyor. Bize List olarak dönecek.
        // Elementleri de for-each ile alabiliriz
        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='form-group'])[4]/div/label"));

        for (WebElement tage : elements){
            System.out.println(tage.getText());
            // tage.click();   bununla da tum kutucuklara tik atabilirsiniz
        }


        driver.quit();
    }
}
