package com.eurotech.tests.tag_09;

import com.eurotech.utility.WebDriverFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;

public class SelectDropdown {
    /**

    * Gehen Sie https://demoqa.com/select-menu
    * Verifizieren Sie, dass erste Farbe Red ist
    * Wahlen Sie drei Farben aus
    * Verifizieren Sie drei Farben
     */
    WebDriver driver;
    WebElement dropDownMenu;
    Select select;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/select-menu");
        dropDownMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        select = new Select(dropDownMenu);
    }
    @Test
    public void dropDownInfo() {

        select.selectByIndex(0);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Green"); // text olarak bulup seciyor
        System.out.println(select.getFirstSelectedOption().getText());
        // option secildikten sonra webelemente döndurup,onu da text'e döndürür

        select.selectByValue("7"); // value'si 7 olana gidiyor onu seciyor
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(1); // indeksi 1 olan elementi buluyor
        System.out.println(select.getFirstSelectedOption().getText());

        // select.deselectByVisibleText("Blue"); - bu hata verir cunku 2 tane renk secilemez sadece 1 tane secilebiliyor
        //ama bunu multiselect butonu ile yapabiliriz

        List<WebElement> optionsList = select.getOptions();
        System.out.println("optionsList.get(3).getText() = " + optionsList.get(3).getText());
        List<WebElement> expectedList = new ArrayList<>(); // bos yeni list
        for (WebElement element : optionsList){// tüm optionlari yazdirmak icin kullanabiliriziriz
            //System.out.println("element.getText() = " + element.getText());
            expectedList.add(element); // bos list'e ekliyoruz
        }
        Assert.assertEquals(optionsList,expectedList);

    }

    @Test
    public void selectDropDownTest() {

        String expectedErsteFarbe = "Red";
        String actualErsteFarbe = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedErsteFarbe,actualErsteFarbe);

        select.selectByIndex(3);
        String actualVierteFarbe = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualVierteFarbe,"Yellow");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
