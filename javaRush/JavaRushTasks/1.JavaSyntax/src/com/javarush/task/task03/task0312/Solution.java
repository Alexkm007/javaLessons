package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
       System.out.println(convertToSeconds(10));
       System.out.println(convertToSeconds(15));
    }

    public static int convertToSeconds(int hour){
        return hour*3600;
    }
}
