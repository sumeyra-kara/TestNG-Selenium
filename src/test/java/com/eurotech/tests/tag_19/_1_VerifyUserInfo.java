package com.eurotech.tests.tag_19;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import com.eurotech.utility.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_VerifyUserInfo extends TestBase {
    /*
     * Gehen Sie http://www.eurotech.study/login
     * Melden Sie an
     * Verifizieren Sie Welcome batch16
     * Klicken Sie Edit Profile button
     * Verifizieren Sie GitHub link - batch16
     * Klicken Sie Go Back button
     * Verifizieren Sie erste Benutzer Title - SDET
     * Melden Sie ab
     * Verifizieren Sie, dass Sie abgemeldet sind
     */
    @BeforeMethod
    public void setUpClass(){
        loginPage=new LoginPage();
    }

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    EditProfilePage editProfile = new EditProfilePage();
    BasePage basePage = new DashboardPage();

    @Test
    public void test() {
        extentLogger = reports.createTest("Verify User Info");
        extentLogger.info("Go to "+ ConfigReader.getProperty("url"));

        extentLogger.info("Melden Sie an");
        loginPage.login();

        extentLogger.info("Verifizieren Sie Welcome batch16");
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome batch16");

        extentLogger.info("Klicken Sie Edit Profile button");
        dashboardPage.addList.get(0).click();

        extentLogger.info("Verifizieren Sie GitHub link - batch16");
        Assert.assertEquals(editProfile.githubInput.getAttribute("value"),"batch16");

        extentLogger.info("Klicken Sie Go Back button");
        editProfile.goBackButton.click();

        extentLogger.info("Verifizieren Sie erste Benutzer Title - SDET");
        Assert.assertEquals( dashboardPage.title.getText(),"SDET");

        extentLogger.info("Melden Sie ab");
        basePage.subMenuBar2("Logout").click();
        //dashboardPage.logout();

        extentLogger.info("Verifizieren Sie, dass Sie abgemeldet sind");
        BrowserUtils.verifyURLContains("login");
        extentLogger.pass("Test Pass!");

    }
}
