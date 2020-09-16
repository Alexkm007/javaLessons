package com.javarush.task.task29.task2909.human;

public class Soldier extends Human{
    public Soldier(String name,int age) {
        super(name,age);
//        super.setAge(age);
//        super.setName(name);
    }

    public void live() {
        fight();
    }

    public void fight() {

    }

}
