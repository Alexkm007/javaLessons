package com.javarush.task.task12.task1204;

/* 
То ли птица, то ли лампа
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        String className = o.getClass().getSimpleName();
        switch (className) {
            case "Cat":
                className = "Кошка";
                break;
            case "Bird":
                className = "Птица";
                break;
            case "Lamp":
                className = "Лампа";
                break;
            case "Dog":
                className = "Собака";
                break;
        }
        System.out.println(className);
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
