package ru.alex.linksOrZnach;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.x  = 100;
        B.changeLinks(a);
        System.out.println(a.x);
        B.changeValue(a);
        System.out.println(a.x);
    }
}
