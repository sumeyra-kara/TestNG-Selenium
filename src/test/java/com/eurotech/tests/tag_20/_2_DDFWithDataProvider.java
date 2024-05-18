package com.eurotech.tests.tag_20;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _2_DDFWithDataProvider {
    /**
     * DDT Data Driven Testing
     * DDF Data Driven Framework
     */

    @DataProvider // testNG'den gelir. bu gelen datayi teste baglayacagiz
    public Object[][] tvAndRating(){
        String [][] data = {
                {"Breaking Bad", "9"},
                {"Haus", "7"},
                {"Game of Thrones", "8"},
                {"Köyden İndim Şehre", "6"},
                {"Sherlock", "5"},
                {"Black List", "10"}
        };
        return data;
    }

    @Test(dataProvider = "tvAndRating")
    public void dataTest(String tvShow, String rating){
        System.out.println("Tv Show " + tvShow + " rating is " + rating);
    }

}
