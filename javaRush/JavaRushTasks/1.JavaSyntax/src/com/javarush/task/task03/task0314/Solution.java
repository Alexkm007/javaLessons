package com.javarush.task.task03.task0314;

/* 
Таблица умножения Ӏ Java Syntax: 3 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String r = "";
        for (int i = 1; i < 11; i++){
            String f = "";
            for (int k = i; k < i*10+1; k+=i){
                f =  f + k + " ";
            }
            System.out.println(f.trim());
        }
    }
}
