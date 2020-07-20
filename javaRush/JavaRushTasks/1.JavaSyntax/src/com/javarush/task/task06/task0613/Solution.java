package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов
        for (int i=1;i<=10;i++){
         Cat cat = new Cat();
        }
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        // Создай статическую переменную catCount
        public static int catCount =0;

        public Cat(){
            catCount++;
        }
        // Создай конструктор
    }
}
