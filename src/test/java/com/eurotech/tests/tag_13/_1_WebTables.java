package com.eurotech.tests.tag_13;
import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
public class _1_WebTables {
    /**
     * Gehen Sie https://qa-practice.netlify.app/web-table
     * Manipulieren Sie WebTable
     * getAllTable()
     * getHeaders()
     * getAllData()
     * getAllFirstNames()
     * getAllLastNames()
     * getRow()
     * getCell(
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa-practice.netlify.app/web-table");
    }
    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void test() {
        WebElement allTable = driver.findElement(By.xpath("//table[@id='peopleTable']"));
        System.out.println("allTable.getText() = " + allTable.getText());
        System.out.println("****************");
    }

    @Test
    public void headerTest() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='peopleTable']/thead/tr/th"));
        for (WebElement title : headers){
            System.out.println("title.getText() = " + title.getText());
        }
        System.out.println("-----------");
    }

    @Test
    public void allData() {
        List<WebElement> allData = driver.findElements(By.xpath("//table[@id='peopleTable']/tbody/tr"));
        System.out.println("letzte Data " + allData.get(allData.size() - 1).getText());
        for (WebElement data :  allData){
            System.out.println("data.getText() = " + data.getText());
        }
    }

    @Test
    public void getFirstName() {
        List<WebElement> getFirstName = driver.findElements(By.xpath("//table[@id='peopleTable']/tbody/tr/td[1]"));
        // list'i for-each ile yazdirabiliriz
        WebElement jacob = driver.findElement(By.xpath("//table[@id='peopleTable']/tbody/tr[2]/td[1]"));
        System.out.println("jacob.getText() = " + jacob.getText());
        //method ile dinamisch bulabiliriz
        System.out.println("getFirstName2(2).getText() = " + getFirstNameMethod(2).getText());
    }
    private WebElement getFirstNameMethod (int index){
        String name = "//table[@id='peopleTable']/tbody/tr["+index+"]/td[1]";
        return driver.findElement(By.xpath(name));
    }

    @Test
    public void lastName() {
        List<WebElement> lastName = driver.findElements(By.xpath("//table[@id='peopleTable']/tbody/tr/td[2]"));
        for (WebElement lastN : lastName){
            System.out.println("lastN.getText() = " + lastN.getText());
        }
        System.out.println("getLastNameMethod(2).getText() = " + getLastNameMethod(2).getText());
    }
    private WebElement getLastNameMethod (int index){
        String name = "//table[@id='peopleTable']/tbody/tr["+index+"]/td[2]";
        return driver.findElement(By.xpath(name));
    }

    @Test
    public void getRow() {
        List<WebElement> getRow = driver.findElements(By.xpath("//table[@id='peopleTable']/tbody/tr"));
        System.out.println("getRow.size() = " + getRow.size());
        System.out.println("getRowMethod(1).getText() = " + getRowMethod(1).getText());
    }
    private WebElement getRowMethod(int index){
        String name = "(//table[@id='peopleTable']/tbody/tr)["+index+"]";
        return driver.findElement(By.xpath(name));
    }

    @Test
    public void getCellTest() {
        WebElement email = driver.findElement(By.xpath("//table[@id='peopleTable']/tbody/tr[3]/td[3]"));
        System.out.println("email.getText() = " + email.getText());
        System.out.println("getCell(2,2).getText() = " + getCell(2, 2).getText());
    }

    private WebElement getCell(int zeile, int celle){ // row, column
        String name = "//table[@id='peopleTable']/tbody/tr["+zeile+"]/td["+celle+"]";
        return driver.findElement(By.xpath(name));
    }

    @Test
    public void test2() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='peopleTable']/tbody/tr/td"));
        for (WebElement a : elements){
            System.out.println("a.getText() = " + a.getText());
        }


    }

    //
}
