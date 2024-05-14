package com.eurotech.tests.tag_17;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import com.eurotech.utility.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task extends TestBase {
    /*
     * Gehen Sie http://www.eurotech.study/login
     * Melden Sie an
     * Verifizieren Sie Welcome batch16
     * Verifizieren Sie "Edit Profile" "Add Experience" "Add Education" als List<String>
     * Melden Sie ab (Erstellen Sie logout() Method auf der BasePage)
     * Verifizieren Sie, dass Sie abgemeldet sind
     *** Benutzen Sie POM
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void test() {
        loginPage.login();
        String expectedText = "Welcome batch16";
        Assert.assertTrue(dashboardPage.welcomeText.getText().contains(expectedText));

        List<String> expectedtAddList = new ArrayList<>();
        expectedtAddList.add("Edit Profile");
        expectedtAddList.add("Add Experience");
        expectedtAddList.add("Add Education");
        /*List<WebElement> addList = dashboardPage.addList;
        List<String> actualAddList = new ArrayList<>();
        for (WebElement each : addList){
            actualAddList.add(each.getText());
        }
        Assert.assertEquals(actualAddList,expectedtAddList);
         */
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.addList),expectedtAddList);

        BasePage basePage = new DashboardPage();
        basePage.subMenuBar2("Logout").click();

        String expectedUrl  ="http://www.eurotech.study/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);


    }
}
