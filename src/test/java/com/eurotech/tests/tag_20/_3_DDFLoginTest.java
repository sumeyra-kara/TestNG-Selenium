package com.eurotech.tests.tag_20;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.ConfigReader;
import com.eurotech.utility.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3_DDFLoginTest  extends TestBase {
    @DataProvider
    public Object [][] userData(){
        String path = "src/test/resources/DevEx.xlsx";
        ExcelUtil data = new ExcelUtil(path,"Test Data");
        return data.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void loginTestDDT(String username, String password, String title, String company, String name){
        extentLogger = reports.createTest(name + "'s login test");

        extentLogger.info("Go to login page " + ConfigReader.getProperty("url"));
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Click I understand button");
        loginPage.confirmButton.click();

        extentLogger.info("Enter a valid username");
        loginPage.inputEmail.sendKeys(username);

        extentLogger.info("Enter a valid password");
        loginPage.inputPassword.sendKeys(password);

        extentLogger.info("Click Login button");
        loginPage.inputLogin.click();

        String expectedMessage = "Welcome " + name;
        extentLogger.info("Verify that the expected message is " + expectedMessage);
        Assert.assertEquals(dashboardPage.welcomeText.getText(), expectedMessage);

        extentLogger.info("Verify that title is " + title);
        Assert.assertEquals(dashboardPage.userTitle(1).getText(), title);

        extentLogger.info("Verify that " + name + " is working in " + company);
        Assert.assertEquals(dashboardPage.userCompany(1).getText(), company);

        extentLogger.pass("Test Passed");

    }



}
