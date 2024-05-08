package com.eurotech.tests.tag_10;

import com.eurotech.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class HtmlPopups {
    /**
     * Gehen Sie zur https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=e893a
     * Klicken Sie Confirm button
     * Klicken Sie Yes button
     * Verifizieren Sie Confirm Message - You have accepted
     */
    @Test
    public void popupTest() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=e893a");
        WebDriverFactory.wait(2);

        WebElement confirm = driver.findElement(By.xpath("//button[@id='j_id_7w:j_id_7y']"));
        confirm.click();
        WebDriverFactory.wait(2);

        WebElement yesButton = driver.findElement(By.xpath("//button[@id='j_id_7w:j_id_82']"));
        yesButton.click();

        String message = driver.findElement(By.xpath("//p[.='You have accepted']")).getText();
        Assert.assertEquals(message,"You have accepted");
        driver.quit();
    }
}
