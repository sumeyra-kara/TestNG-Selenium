package com.eurotech.tests;
import com.eurotech.utility.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    /*
  TestBase class'ini bu class'i parent edinecek class'larda driver olusturmamak ve ayarlari yeniden
  yapmamak icin kullaniyoruz.
   */
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver,20);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
