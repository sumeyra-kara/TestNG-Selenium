package com.eurotech.pages;

import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilesPage  extends BasePage{
    @FindBy(id = "dualfilter-skills-btn")
    public WebElement skill;

    @FindBy(id = "singlefilter-input")
    public WebElement skillText;

    @FindBy(id = "filter-selection-form-btn")
    public WebElement filter;

    @FindBy(xpath = "(//div[@id='profile-item-container']//li[2])[1]")
    public WebElement selenium;

    @FindBy(xpath = "(//ul[@id='profile-item-detail-skills'])[1]")
    public WebElement ersteSkill;

    public WebElement skill(int index) { //  // skillerini dinamik olarak almak istersek
        String skillPath = "(//ul[@id='profile-item-detail-skills'])[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(skillPath));
    }


    @FindBy(xpath = "(//div[@id='profile-item-container']//div//h2)[1]")
    public WebElement ersteName;
    public WebElement name(int index) { // dinamik olarak yaparsak
        String namePath = "(//div[@id='profile-item-container']//div//h2)["+index+"]";
        return Driver.getDriver().findElement(By.xpath(namePath));
    }







}
