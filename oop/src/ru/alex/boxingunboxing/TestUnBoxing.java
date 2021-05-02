package ru.alex.boxingunboxing;


public class TestUnBoxing {
    void printInt(int x){
        System.out.println("Значение типа int");
        System.out.println(x);
    }

    void printInt(Integer x){
        System.out.println("Значение типа Integer");
        System.out.println(x);
    }
}
