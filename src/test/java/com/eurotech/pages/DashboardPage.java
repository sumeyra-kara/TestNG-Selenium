package com.eurotech.pages;

import com.eurotech.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(id = "dashboard-p1")
    public WebElement welcomeText;

    @FindBy(xpath = "//a[@class='btn btn-light']")
    public List<WebElement>  addList;


}
