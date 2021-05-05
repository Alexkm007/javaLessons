package ru.alex.initial;

public class InitializerC extends InitializerP {

    static String field = "static child";

    static {
        System.out.println("static block child");
        System.out.println(field);
    }

    String fieldNs = "non static field";

    {
        System.out.println("non static block child");
        System.out.println(fieldNs);
    }

    public InitializerC() {
        System.out.println("Constructor child");
    }
}
