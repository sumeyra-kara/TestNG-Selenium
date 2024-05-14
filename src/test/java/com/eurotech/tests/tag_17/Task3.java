package com.eurotech.tests.tag_17;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilesPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3  extends TestBase {
    /*
     * Gehen Sie http://www.eurotech.study/login
     * Melden Sie an
     * Verifizieren Sie Welcome batch16
     * Gehen Sie Developers Page
     * Klicken Sie Skill
     * Schreiben Sie selenium in der Textarea
     * Klicken Sie Filter Button
     * Verifizieren Sie, dass erste Developer HTML Skill hat
     * Geben Sie den Name des ersten Developers aus
     * Melden Sie ab
     * Verifizieren Sie, dass Sie abgemeldet sind
     *** Benutzen Sie POM
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    BasePage basePage = new DashboardPage();
    ProfilesPage profilesPage = new ProfilesPage();

    @Test
    public void test() {
        loginPage.login();
        String expectedText = "Welcome batch16";
        Assert.assertTrue(dashboardPage.welcomeText.getText().contains(expectedText));
        basePage.menuBar("Developers").click();

        profilesPage.skill.click();
        profilesPage.skillText.sendKeys("selenium");
        profilesPage.filter.click();
        //Assert.assertEquals(profilesPage.selenium.getText(),"Selenium");
        Assert.assertTrue(profilesPage.skill(1).getText().contains("Selenium")); // dinamik methodu ile yaparsak

        System.out.println("profilesPage.name.getText() = " + profilesPage.ersteName.getText());
        Assert.assertTrue(profilesPage.name(1).getText().contains("TestAccount"));
        basePage.subMenuBar2("Logout").click();
        BrowserUtils.verifyURLContains("login");

    }
}
