package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        String animal = o.getClass().getSimpleName();
        String rezult = "";
        switch (animal) {
            case "Cat":
                rezult = "Кот";
                break;
            case "Tiger":
                rezult = "Тигр";
                break;
            case "Lion":
                rezult = "Лев";
                break;
            case "Bull":
                rezult = "Бык";
                break;
            case "Cow":
                rezult = "Корова";
                break;
            default:
                rezult = "Животное";
                break;
        }
        return rezult;
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
