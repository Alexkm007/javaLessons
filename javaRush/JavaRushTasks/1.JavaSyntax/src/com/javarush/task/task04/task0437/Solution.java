package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) {
        for(int i =1;i<=10;i++){
            String s = "";
            for(int k=1;k<=i;k++){
               s+="8";
            }
            System.out.println(s);
        }

    }
}
