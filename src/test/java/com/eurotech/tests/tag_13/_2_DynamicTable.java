package com.eurotech.tests.tag_13;
import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
public class _2_DynamicTable {
    /*
     Gehen Sie https://demoqa.com/webtables
     * Manipulieren Sie WebTable dynamisch
     * getRow() - nach Name
     * getEmail() - nach Name
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/webtables");
    }
    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void allTable() {
        // //div[@role='rowgroup'] satir
        // //div[@role='columnheader']  sütun
        List<WebElement> alltable = driver.findElements(By.xpath("//div[@role='gridcell']"));
        for (WebElement all : alltable){
            System.out.println("all.getText() = " + all.getText());
        }
    }
    @Test
    public void getEmailTest() {
        WebElement eMail = driver.findElement(By.xpath("//div[.='Cantrell']/following-sibling::div[2]"));
        System.out.println("eMail.getText() = " + eMail.getText());
        System.out.println("getEMailMethod(\"Vega\").getText() = " + getEMailMethod("Vega").getText());
    }
    private WebElement getEMailMethod(String lastname){
        String email = "//div[.='"+lastname+"']/following-sibling::div[2]";
        WebElement mail = driver.findElement(By.xpath(email));
        return mail;
        // //div[.='Cantrell']/following-sibling::div[5]
    }

    @Test
    public void testallgemein() {
        List<WebElement> celle = driver.findElements(By.xpath("//div[@role='columnheader']"));
        System.out.println("celle.size() = " + celle.size());
        System.out.println("allMethod(\"Vega\", 2).getText() = " + allMethod("Vega", 3).getText());
        System.out.println("all(\"Cierra\",\"Vega\").getText() = " + ismeGoreMailBulma("Cierra", "Vega").getText());
    }
    private WebElement allMethod(String lastname, int index){
        String a = "//div[.='"+lastname+"']/following-sibling::div["+index+"]";
        WebElement information = driver.findElement(By.xpath(a));
        return information;
    }

    private WebElement ismeGoreMailBulma(String firstname,String lastName){
        String a = "(//div[.='"+firstname+"']|//div[.='"+lastName+"']/following-sibling::div[2])[2]";
        WebElement information = driver.findElement(By.xpath(a));
        return information;
    }

    @Test
    public void getRow() {
        WebElement element = driver.findElement(By.xpath("//div[.='Cantrell']/parent::*"));
       // System.out.println("element.getText() = " + element.getText());
        System.out.println("ismeGoreRow(\"Vega\") = " + ismeGoreRow("Vega"));
    }
    private  String ismeGoreRow(String lastname){
        WebElement element = driver.findElement(By.xpath("//div[.='"+lastname+"']/parent::*"));
        String text = element.getText();
        return text;
    }
}
