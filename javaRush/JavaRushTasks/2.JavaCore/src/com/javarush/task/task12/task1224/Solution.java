package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
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
            default:
                rezult = "Животное";
                break;
        }
        return rezult;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
