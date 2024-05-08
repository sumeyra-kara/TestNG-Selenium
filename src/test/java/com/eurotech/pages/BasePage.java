package com.eurotech.pages;

import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "nav__menu-item") // Verifizieren sie 3 menu
    public List<WebElement> menuList;

    public WebElement menuBar (String menu){
        String menuPath = "//*[.='"+menu+"']";
        return Driver.getDriver().findElement(By.xpath(menuPath));
    }
    public WebElement subMenuBar(String subMenu){
        Actions actions = new Actions(Driver.getDriver());
        WebElement myAccount = Driver.getDriver().findElement(By.xpath("//span[.='My Account']"));
        actions.moveToElement(myAccount).perform();
        String subMenuPath = "//span[text()='"+subMenu+"']";
        return Driver.getDriver().findElement(By.xpath(subMenuPath));
    }
}
