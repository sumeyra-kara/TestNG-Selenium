package com.eurotech.tests.tag_09;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ListOfElements {
    /*
     * Gehen Sie https://the-internet.herokuapp.com/
     * Geben Sie alle Urls und ihre Texte aus
     * Verifizieren Sie List-size() = 4
     */
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        System.out.println("DB ist verbunden");
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> urlElements = driver.findElements(By.xpath("//ul/li/a"));
        for (WebElement url : urlElements){
            String text = url.getText();
            String href = url.getAttribute("href");
            System.out.println(text + " " + href);
        }

        int actualUrlSize = urlElements.size();
        int expectedUrlSize = 44;
        Assert.assertEquals(actualUrlSize,expectedUrlSize);



    }

    @Test
    public void testUrl() {
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("DB ist abgeschlossen");
    }
}
