package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код

    private String name,address,color;
    private int age,weight;

    public static void main(String[] args){}

    public void initialize(String name){
        this.name = name;
        this.weight = 3;
        this.age = 1;
        this.color = "none";
    }
    public void initialize(String name,int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "none";
    }

    public void initialize(int weight,String color){
        this.color = color;
        this.age = 1;
        this.weight = weight;

    }
    public void initialize(int weight,String color,String address){
        this.color = color;
        this.weight = weight;
        this.address = address;
        this.age     = 1;
    }

    public void initialize(String name, int age)
    {
        this.name = name;
        this.weight = 1;
        this.age = age;
        this.color = "none";
    }

}
