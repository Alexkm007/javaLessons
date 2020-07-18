package com.javarush.task.task05.task0503;


/* 
Геттеры и сеттеры для класса Dog
*/

public class Dog {
    //напишите тут ваш код
    private String name;
    private int age;

    public static void main(String[] args) {

    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
