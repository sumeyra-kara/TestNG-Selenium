package com.eurotech.tests.tag_06;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_Task3 {
    public static void main(String[] args) {
        /*
        Aufgabe 3
        Gehen Sie zur https://www.trendyol.com.tr/
        Schliessen Sie pop-up, wenn benötigt
        Suchbegriff "yazılım" eingeben
        Klicken Sie auf die Suchtaste
        Klicken Sie auf "yazılım ürünleri" links auf der Seite
        Klicken Sie auf "Yüksek Puanlı Ürünler" oben auf der Seite
        Klicken Sie auf das erste Produkt
        Produkt in den Warenkorb legen
        Navigieren Sie zum Warenkorb
        Verifizieren Sie den Preis und die Quantität
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.trendyol.com/");



    }
}
