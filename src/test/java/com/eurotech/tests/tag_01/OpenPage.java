package com.eurotech.tests.tag_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/"); // bu url sayfasina götürür

        // driver.close(); // acilmis olan sayfayi(Fenster/Window/Tab) kapatir (schlieest das aktuelle Fenster)

        Thread.sleep(3000); // 3 dk bekliyor sayfada

        driver.quit(); // test sirasinda birden fazla window acilmissa tümünü kapatir

        driver = new ChromeDriver();
        driver.get("https://eurotechstudy.com/en");
        Thread.sleep(2000);
        driver.close();


    }
}
