package com.eurotech.tests.tag_07;

import org.testng.annotations.*;

public class BeforeAndAfterMethods {

    @BeforeClass
    public void beforeClass(){ // class'in basinda sadece 1 kez calisir
        System.out.println("***Before Class***");
    }

    @AfterClass
    public void afterClass(){ // class'in sonuunda sadece 1 kez calisir
        System.out.println("***After Class***");
    }

    @BeforeMethod // her bir testten önce 1 kez calisir
    public void beforeMethod(){
        System.out.println("***Before Method***");
    }

    @AfterMethod
    public void afterMethod(){ // her bir testten sonra1 kez calisir
        System.out.println("***After Method***");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }

}
