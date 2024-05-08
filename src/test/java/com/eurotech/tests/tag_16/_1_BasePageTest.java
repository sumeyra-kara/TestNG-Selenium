package com.eurotech.tests.tag_16;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _1_BasePageTest extends TestBase {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void menuBartest() {
        loginPage.login();

        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Developers");
        expectedMenu.add("All Posts");
        expectedMenu.add("My Account");

        List<String> actualMenuList = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualMenuList, expectedMenu);
    }
}
