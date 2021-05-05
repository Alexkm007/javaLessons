package ru.alex.initial;

public class InitializerP {

    static String name = "Alex";
    static {
        System.out.println("static block parent");
        System.out.println(name);
        name = "Fedor";
    }

    String email = "aa@bb.com";

    {
        System.out.println("non static block parent");
        System.out.println(email);
        email = "vv@ff.ru";
    }

    public InitializerP() {
        System.out.println("Constructor Parent");
    }

}
