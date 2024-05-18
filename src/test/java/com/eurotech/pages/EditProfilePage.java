package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage{

    @FindBy(xpath= "//a[@class='btn btn-light my-1']")
    public WebElement goBackButton;


    @FindBy(id= "editprofile-from-github-input")
    public WebElement githubInput;
}
