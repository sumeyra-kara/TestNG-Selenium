package com.eurotech.tests.tag_02;

import com.eurotech.utility.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class NavigationMethods {

    public static void main(String[] args) throws MalformedURLException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebDriverFactory.wait(2);
        URL url = new URL(String.valueOf("https://eurotechstudy.com/en"));
        driver.navigate().to(url); // navigate method nimmt sowohl ein URLals auch ein String
        // driver.get(url); --- wir können für get Method nur String einsetzen
        // driver.get("https://eurotechstudy.com/en");

        // driver.navigate().to("https://eurotechstudy.com/en"); // bizi verilen sayfaya götürür

        WebDriverFactory.wait(2);

        driver.navigate().back(); // bizi bir önceki sayfaya göötürür--zurückkommen
        WebDriverFactory.wait(2);

        driver.navigate().refresh(); // icinde bulunduguumuz sayfayi yeniler

        //WebDriver.Navigation navigate=driver.navigate();--navigate ist ein Interface.Wir können ein Variable zuweisen.
        // navigate.refresh();
        WebDriverFactory.wait(2);

        driver.navigate().forward(); // bizi sonraki sayfaya götürür--vorwarts gehen
        WebDriverFactory.wait(2);

        driver.close();



    }
}
