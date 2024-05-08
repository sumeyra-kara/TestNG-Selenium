package com.eurotech.tests.tag_15;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.ConfigReader;
import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_PositiveLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    @Test
    public void positiveTest() {
        driver.get(ConfigReader.getProperty("url"));
        loginPage.confirmButton.click();
        loginPage.inputEmail.sendKeys(ConfigReader.getProperty("username"));
        loginPage.inputPassword.sendKeys(ConfigReader.getProperty("password"));
        loginPage.inputLogin.click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.welcomeText));
        Assert.assertTrue(dashboardPage.welcomeText.getText().contains("Teacher"));

    }

    @Test
    public void positiveLoginTestwithMethod() {
        loginPage.login();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.welcomeText));
        Assert.assertTrue(dashboardPage.welcomeText.getText().contains("Teacher"));


    }
}
