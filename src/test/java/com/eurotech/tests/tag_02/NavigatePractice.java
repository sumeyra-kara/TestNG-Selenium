package com.eurotech.tests.tag_02;

import com.eurotech.utility.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatePractice {
    /* gehen sie zuerst https://www.amazon.com/
    Navigieren zu https://www.etsy.com/
    Zurückkommen
    Seite aktualisieren
    vorwärts gehen
    die Seite schließen
    FÜR JEDEN SCHRITT 2 SEKUNDEN WARTEN
*/

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/");
        WebDriverFactory.wait(2);

        driver.navigate().to("https://www.etsy.com/");
        WebDriverFactory.wait(2);

        driver.navigate().back();
        WebDriverFactory.wait(2);

        driver.navigate().refresh();
        WebDriverFactory.wait(2);

        driver.navigate().forward();
        WebDriverFactory.wait(2);

        driver.close();
    }
}
