package com.eurotech.tests.tag_16;

import com.eurotech.tests.TestBase;
import com.eurotech.utility.BrowserUtils;
import com.eurotech.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _4_AmazonTest extends TestBase {
    /*
     * Gehen Sie https://www.amazon.sg/
     * Klicken Sie dynamisch Account and Lists > Your Account elements
     */
    // schreiben sie custom method um alle Elements zu klicken
    // diese method nimmt nur ein string accountName Parameter
    // gibt ein WebElement zurück


    // schreiben sie @Test method um diese Method zu benutzen
    public WebElement amazonAccountList(String accountName){
        String menuPath = "//span[text()='"+accountName+"']";
        return Driver.getDriver().findElement(By.xpath(menuPath));
    }

    @Test
    public void test() {
        driver.get("https://www.amazon.sg/");
        WebElement accountAndList = driver.findElement(By.xpath("//span[text()='Account and Lists']"));
        BrowserUtils.hover(accountAndList);
        amazonAccountList("Your Account").click();
        BrowserUtils.waitFor(3);
    }
}
