package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostsPage extends BasePage {

    @FindBy(xpath = "//textarea[@name='title']") // add a Title
    public WebElement addTitle;

    @FindBy(xpath = "//textarea[@name='text']") // textareaInput
    public WebElement textareaInput;
    @FindBy(xpath = "(//input[@type='submit'])[1]") //
    public WebElement submitButton;
    @FindBy(xpath = "//div[@class='alert alert-success']") //
    public WebElement postCreatedMessage;



}
