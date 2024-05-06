package com.eurotech.tests.tag_12;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_FileUpload {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }
    @Test
    public void fileUploadFromDesktop() {
        /**
         * Gehen Sie https://webdriveruniversity.com/File-Upload/index.html
         * Hochladen Sie eine Datei vom Desktop
         */

        driver.get("https://webdriveruniversity.com/File-Upload/index.html");
        String filePath ="C:/Users/User/Desktop/Microsoft Word-Dokument (neu).docx";

        WebElement chooseElement = driver.findElement(By.id("myFile"));
        chooseElement.sendKeys(filePath);
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
    }

    @Test
    public void fileUploadFromProject() {
        driver.get("https://webdriveruniversity.com/File-Upload/index.html");

        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath); // C:\Users\User\IdeaProjects\TestNG-Selenium

        String filePath = "src/test/resources/Microsoft Word-Dokument (neu).docx";
        String fullPath = projectPath + "/"+filePath;
        System.out.println("fullPath = " + fullPath);

        WebElement chooseElement = driver.findElement(By.id("myFile"));
        chooseElement.sendKeys(fullPath);

    }
}
