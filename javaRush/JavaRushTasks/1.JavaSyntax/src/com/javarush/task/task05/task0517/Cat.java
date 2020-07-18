package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public static void main(String[] args) {

    }
    public Cat(String name){
        this.name = name;
        this.age = 1;
        this.color = "белый";
        this.weight = 10;
    }
    public Cat(String name,int weight, int age){
        this.name = name;
        this.age = age;
        this.color = "белый";
        this.weight = weight;
    }
    public Cat(String name,int age){
        this.name = name;
        this.age = age;
        this.color = "белый";
        this.weight = 3;
    }
    public Cat(int weight, String color){
        this.age = 3;
        this.color = color;
        this.weight = weight;
    }
    public Cat(int weight, String color, String address){
        this.color = color;
        this.weight = weight;
        this.address = address;
        this.age = 3;
    }
}
