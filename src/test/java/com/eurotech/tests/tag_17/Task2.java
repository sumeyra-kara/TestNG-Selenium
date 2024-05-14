package com.eurotech.tests.tag_17;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.PostsPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 extends TestBase {
    /*
     * Gehen Sie http://www.eurotech.study/login
     * Melden Sie an
     * Verifizieren Sie Welcome batch16
     * Klicken Sie My Posts
     * Verifizieren Sie, dass Sie sich auf der Posts Seite befinden.
     * Schreiben Sie etwas im Teil "Add a title"
     * Schreiben Sie etwas im Teil "Create a post"
     * Klicken Sie Submit Button
     * Verifizieren Sie Post Created (Pausieren Sie die Seite, um das Element zu identifizieren)
     * Melden Sie ab
     * Verifizieren Sie, dass Sie abgemeldet sind
     *** Benutzen Sie POM
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    BasePage basePage = new DashboardPage();
    PostsPage postsPage = new PostsPage();
    @Test
    public void test() {
        loginPage.login();
        String expectedText = "Welcome batch16";
        Assert.assertTrue(dashboardPage.welcomeText.getText().contains(expectedText));

        basePage.subMenuBar2("My Posts").click();
        BrowserUtils.verifyURLContains("posts");

        postsPage.addTitle.sendKeys("Java kolaydi");
        postsPage.createPost.sendKeys("Selenium kompleks");
        postsPage.submit.click();

        Assert.assertEquals(postsPage.postMessage.getText(),"Post Created");

        basePage.subMenuBar2("Logout").click();
        //String expected  ="http://www.eurotech.study/login";
        //String actualUrl = driver.getCurrentUrl();
       // Assert.assertEquals(actualUrl,expected);
        BrowserUtils.verifyURLContains("login");

    }
}
