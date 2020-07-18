package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        String s = "";
        while (i <= 10) {
            int k = 1;
            s = "";
            while (k <= 10) {
                s +=k*i + " ";
                k++;
            }
            i++;
            System.out.println(s.trim());
        }

    }
}
