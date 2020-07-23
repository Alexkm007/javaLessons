package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human h1 = new Human("Петя", true, 60);
        Human h2 = new Human("Вася", true, 60);
        Human h3 = new Human("Света", true, 60);
        Human h4 = new Human("Аня", true, 60);
        Human h5 = new Human("Жора", true, 30, h1, h3);
        Human h6 = new Human("Оля", true, 30, h2, h4);
        Human h7 = new Human("д1", true, 14, h5, h6);
        Human h8 = new Human("д2", false, 13, h5, h6);
        Human h9 = new Human("д3", true, 13, h5, h6);
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(h4.toString());
        System.out.println(h5.toString());
        System.out.println(h6.toString());
        System.out.println(h7.toString());
        System.out.println(h8.toString());
        System.out.println(h9.toString());
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.age = age;
            this.name = name;
            this.sex = sex;
            this.father = father;
            this.mother = mother;

        }

        Human(String name, boolean sex, int age){
            this.age = age;
            this.name = name;
            this.sex = sex;
            this.father = null;
            this.mother = null;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}