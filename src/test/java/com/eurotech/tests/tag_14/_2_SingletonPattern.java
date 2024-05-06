package com.eurotech.tests.tag_14;

public class _2_SingletonPattern {
    private _2_SingletonPattern(){
        // Singleton Pattern kullanilarak baskalari gelip obje üretemesin, erisilemesin diyoruz
        //Constructor'i private yaparak bu class'dan obje olusturularak class üyelerinin kullanilmasinin da önüne gectik
    }
    private static String str; // null
    // encapsülation kullanmak istedigimden private oluyor
    // class adi ile cagirmak icin static yapiyorz.(cunku obje olusturmadik)
    public static String getStr(){

        if (str==null){
            System.out.println("str is null");
            str="value";
        } else {
            System.out.println("there is also a str");
        }
        return str;

    }
}
