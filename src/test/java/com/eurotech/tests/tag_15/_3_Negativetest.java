package com.eurotech.tests.tag_15;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_Negativetest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void test() {
        driver.get(ConfigReader.getProperty("url"));
        loginPage.confirmButton.click();
        loginPage.inputEmail.sendKeys(ConfigReader.getProperty("username"));
        loginPage.inputPassword.sendKeys("somepassword"); // mesela sifreyi yanlis girersek
        loginPage.inputLogin.click();
        Assert.assertEquals(loginPage.inputWarnung.getText(),"Invalid Credentials!"); // bu uyariyi almaliyiz
    }
    @Test
    public void negativeLoginTestWithMethod() {
        loginPage.login(ConfigReader.getProperty("username"),"somepassword");
        Assert.assertEquals(loginPage.inputWarnung.getText(),"Invalid Credentials!");
    }
}
