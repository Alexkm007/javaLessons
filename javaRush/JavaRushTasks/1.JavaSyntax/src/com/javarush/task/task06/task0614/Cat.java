package com.javarush.task.task06.task0614;

/* 
Статические коты
*/

import java.util.ArrayList;


public class Cat {


    public static ArrayList <Cat> cats = new ArrayList <Cat>();

    public Cat() {
    }


    public static void main(String[] args) {
    for  (int i=1; i<=10;i++){
        Cat cat = new Cat();
        Cat.cats.add(cat);
    }
        printCats();
    }

    public static void printCats() {
        for  (int i=0; i<=9;i++){
            System.out.println(Cat.cats.get(i));
        }
    }
}
