package com.eurotech.tests.tag_16;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_MenuBarDynamicClick extends TestBase {

    DashboardPage dashboardPage =new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void dynamicClickWithMethod() {

        loginPage.login();
        dashboardPage.menuBar("Developers").click();
        String expectedDevUrl = "http://www.eurotech.study/profiles";
        Assert.assertEquals(driver.getCurrentUrl(),expectedDevUrl);

        String expectedPostsUrl = "http://www.eurotech.study/posts";
        dashboardPage.menuBar("All Posts").click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedPostsUrl);
    }
    @Test
    public void dynamicClickTest() {
        loginPage.login();
        dashboardPage.menuBar("My Posts").click();
    }
    @Test
    public void subMenuDynamicClickTest() {
        loginPage.login();
        dashboardPage.subMenuBar("My Posts").click();
        String expectedPostUrl = "http://www.eurotech.study/posts";
        Assert.assertEquals(driver.getCurrentUrl(),expectedPostUrl);
        dashboardPage.subMenuBar("Logout").click();
    }
}
