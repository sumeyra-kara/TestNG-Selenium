package com.eurotech.tests.tag_07;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testNGIntro {
    @Test
    public void test(){
        System.out.println("My first Test");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("My second Test");
    } @Ignore

    @Test(priority = 1)
    public void test2(){
        System.out.println("My third Test");
    }

    /*
    @Ignore notasyonu ile o test notasyonunu ignore ediyoruz yani yok sayiyoruz


     */



}
