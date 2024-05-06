package com.eurotech.tests.tag_14;

import com.eurotech.utility.ConfigReader;
import com.eurotech.utility.Driver;
import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.session.EdgeFilter;
import org.testng.annotations.Test;

public class _3_SingletonTest {

    @Test
    public void test() {
        String str1 = _2_SingletonPattern.getStr();
        String str2 = _2_SingletonPattern.getStr();
        String str3 = _2_SingletonPattern.getStr();
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);
    }

    @Test
    public void test2() {
        WebDriver driver = Driver.getDriver();
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        Driver.closeDriver();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Test
    public void test3() {
       // Driver.getDriver().get(ConfigReader.getProperty("url"));
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        //Driver.closeDriver();
    }
    @Test
    public void test4() { // eski yöntemlerle yaparsak
        // WebDriver driver = Driver.getDriver();
        WebDriver driver = WebDriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.get("https://www.google.com/");
        //Driver.closeDriver();
        driver.close();
        driver.get("https://www.google.com/");
    }

}
