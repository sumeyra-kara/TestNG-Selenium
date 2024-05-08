package com.eurotech.pages;

import com.eurotech.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    @FindBy(id = "dashboard-p1")
    public WebElement welcomeText;
}
