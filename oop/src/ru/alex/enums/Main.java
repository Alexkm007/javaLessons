package ru.alex.enums;

public class Main {
    public static void main(String[] args) {
        A a = A.B;
        a.setD("FF");
        A a1 = A.B;
        a1.setD("GG");
        A a2 = A.D;
        System.out.println(a.getD());
        System.out.println(a2.getD());
        System.out.println(a.name());
        System.out.println(a2.name());

        B b = B.ABC;
        B b2 = B.DCF;


    }
}
