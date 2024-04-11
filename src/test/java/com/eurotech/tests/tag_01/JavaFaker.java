package com.eurotech.tests.tag_01;

import com.github.javafaker.Faker;

public class JavaFaker {

    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println("faker.name().name() = " + faker.name().name());
        System.out.println("faker.bothify(\"##\") = " + faker.bothify("##")); // 2 Nummer
        System.out.println("faker.bothify(\"##??\") = " + faker.bothify("##??")); // 2 Nummer + 2 Buchstabe
        System.out.println("faker.bothify(\"test###???@gmail.com\") = " + faker.bothify("test###???@gmail.com"));
        // test + 3 Nummer + 3 Buchstabe +  @gmail.com

        System.out.println("faker.animal() = " + faker.animal().name()); // fake animal Name gegeben ist
        System.out.println("faker.leagueOfLegends() = " + faker.leagueOfLegends().champion());
        System.out.println("faker.leagueOfLegends().location() = " + faker.leagueOfLegends().location());

    }
}
