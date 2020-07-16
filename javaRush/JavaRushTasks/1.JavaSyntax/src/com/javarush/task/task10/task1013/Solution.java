package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private String adress;
        private boolean sex;
        private int height;
        private float weight;

        public Human(String name,int age,String adress, boolean sex, int height, float weight){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name,int age,String adress, boolean sex, int height){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = sex;
            this.height = height;
            this.weight = 75f;
        }
        public Human(String name,int age,String adress, boolean sex){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = sex;
            this.height = 175;
            this.weight = 75f;
        }
        public Human(String name,int age,String adress){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = true;
            this.height = 175;
            this.weight = 75f;
        }
        public Human(String name,int age){
            this.name = name;
            this.age = age;
            this.adress = "N/A";
            this.sex = true;
            this.height = 175;
            this.weight = 75f;
        }
        public Human(String name,int age,String adress, boolean sex, float weight){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = sex;
            this.height = 175;
            this.weight = weight;
        }
        public Human(String name,int age,String adress, float weight){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = true;
            this.height = 175;
            this.weight = weight;
        }
        public Human(String name,int age, float weight){
            this.name = name;
            this.age = age;
            this.adress = "N/A";
            this.sex = true;
            this.height = 175;
            this.weight = weight;
        }
        public Human(String name,int age, boolean sex, int height, float weight){
            this.name = name;
            this.age = age;
            this.adress = "N/A";;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name,int age,String adress, int height, float weight){
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.sex = true;
            this.height = height;
            this.weight = weight;
        }


    }
}
