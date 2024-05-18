package com.eurotech.tests.tag_18;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import com.eurotech.utility.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _2_WrongUsernameTest extends TestBase {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpClass(){
        loginPage=new LoginPage();
        // bunu yazmamizin sebebi reports.flush(); ile oturum dusuyor driver null degil yeni oturum acmadigi icin
        // biz tekrardan yeni nesne üretiyoruz,driverimiz dussun tekrar acalim diye.(eger yapmazsak exception aliriz)
    }



    @Test
    public void wrongUsernameTest() {
        extentLogger = reports.createTest("Wrong username Login Test");
        extentLogger.info("Go to Url" + ConfigReader.getProperty("url"));
        driver.get(ConfigReader.getProperty("url"));

        extentLogger.info("Click I understand Button");
        loginPage.confirmButton.click();

        extentLogger.info("Enter username");
        loginPage.inputEmail.sendKeys("wrongusername@wrong.com");

        extentLogger.info("Enter password");
        loginPage.inputPassword.sendKeys(ConfigReader.getProperty("password"));

        extentLogger.info("Click Login Button");
        loginPage.inputLogin.click();

        extentLogger.info("Verify That NOT Logged In");
        Assert.assertEquals(loginPage.inputWarnung.getText(),"Invalid Credentials!");

        extentLogger.pass("Test Passed");
    }

    @Test(priority = 1)
    public void wrongPasswordTest() {
        extentLogger = reports.createTest("Wrong username Login Test");
        extentLogger.info("Go to Url" + ConfigReader.getProperty("url"));
        driver.get(ConfigReader.getProperty("url"));

        extentLogger.info("Click I understand Button");
        loginPage.confirmButton.click();

        extentLogger.info("Enter username");
        loginPage.inputEmail.sendKeys(ConfigReader.getProperty("username"));

        extentLogger.info("Enter password");
        loginPage.inputPassword.sendKeys("wrongpassword");

        extentLogger.info("Click Login Button");
        loginPage.inputLogin.click();

        extentLogger.info("Verify That NOT Logged In");
        Assert.assertEquals(loginPage.inputWarnung.getText(),"Invalid Credentials!");

        extentLogger.pass("Test Passed");
    }

    @Test(priority = 2)
    public void wrongPasswordTest2() {
        extentLogger = reports.createTest("Wrong username Login Test");
        extentLogger.info("Go to Url" + ConfigReader.getProperty("url"));
        driver.get(ConfigReader.getProperty("url"));

        extentLogger.info("Click I understand Button");
        loginPage.confirmButton.click();

        extentLogger.info("Enter username");
        loginPage.inputEmail.sendKeys(ConfigReader.getProperty("username"));

        extentLogger.info("Enter password");
        loginPage.inputPassword.sendKeys("wrongpassword");

        extentLogger.info("Click Login Button");
        loginPage.inputLogin.click();

        extentLogger.info("Verify That NOT Logged In");
        Assert.assertEquals(loginPage.inputWarnung.getText(),"Invalid Credentials");

        extentLogger.pass("Test Passed");
    }
}
