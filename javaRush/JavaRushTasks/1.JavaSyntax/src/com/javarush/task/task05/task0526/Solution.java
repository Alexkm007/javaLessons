package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Alex",22,"ебеня");
        Man man2 = new Man("Alex2",222,"ебеня2");

        Woman w1 = new Woman("Natasha",33,"ебеня");
        Woman w2 = new Woman("Ira",28,"ебеня");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(w1);
        System.out.println(w2);
    }

    public static class Man {
        private String name;
        private String address;
        private int age;

    public Man(String name, int age, String address){
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public String toString(){
        return this.name + " " + this.age + " " + this.address;
    }

    }

    public static class Woman {
        private String name;
        private String address;
        private int age;

        public Woman(String name, int age, String address){
            this.age = age;
            this.name = name;
            this.address = address;
        }

        public String toString(){
            return this.name + " " + this.age + " " + this.address;
        }

    }

    //напишите тут ваш код
}
