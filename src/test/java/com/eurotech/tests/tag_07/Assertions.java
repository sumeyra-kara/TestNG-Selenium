package com.eurotech.tests.tag_07;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.atomic.AtomicReference;
public class Assertions {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Chrome Driver");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close Chrome Driver");
    }

    @Test
    public void test(){
        Assert.assertEquals("Test","Test","Actual Result and Expected Result are equal");
    }
    @Test
    public void test1(){
        System.out.println("First Test");
        Assert.assertEquals("First","first");
        System.out.println("Second Test");
        Assert.assertEquals("Second","Second");
    }
    @Test
    public void test2(){
        String email = "eurotech@gmail.com";
        Assert.assertTrue(email.contains("@"));
    }
    @Test
    public void test3(){
        Assert.assertFalse(0==0); // false oldugu icin failed verecek
    }
    @Test
    public void test4(){
        String actualResult = "1";
        String expectedResult = "one";
        Assert.assertNotEquals(actualResult,expectedResult); // passed
    }

    /*
    Eger passed olursa hata bildirim mesajini(message) almayiz, failed oldugunda aliriz sadece.
     */



}
