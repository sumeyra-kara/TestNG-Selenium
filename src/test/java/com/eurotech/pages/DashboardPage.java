package com.eurotech.pages;

import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(id = "dashboard-p1")
    public WebElement welcomeText;

    @FindBy(xpath = "//a[@class='btn btn-light']")
    public List<WebElement>  addList;


    @FindBy(xpath= "//*[@id='dashboard-experience-table']//tbody/tr[1]/td[2]")
    public WebElement title;

    public WebElement dashboardMenu(String menu) {
        String menuPath = "//*[text()='" + menu + "']";
        return Driver.getDriver().findElement(By.xpath(menuPath));
    }

    public WebElement userTitle(int index) {
        String titlePath = "(//tbody)[1]/tr[" + index + "]/td[2]";
        return Driver.getDriver().findElement(By.xpath(titlePath));
    }
    public WebElement userCompany(int index) {
        String companyPath = "(//tbody)[1]/tr[" + index + "]/td[1]";
        return Driver.getDriver().findElement(By.xpath(companyPath));
    }


}
