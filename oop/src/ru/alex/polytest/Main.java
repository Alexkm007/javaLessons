package ru.alex.polytest;

public class Main {
    public static void main(String[] args) {
        A a = new A("Alex");
        B b = new B("ZUZU");
        C c = new C("VVV");
        //C.printName((C)a);
        A ca = c;
        C c1 = (C)ca;
        c1.printTest();
    }
}
