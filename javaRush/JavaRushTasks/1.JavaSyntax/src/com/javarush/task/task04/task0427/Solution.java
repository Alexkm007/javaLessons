package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        if (x<1 | x>999){
            return;
        }
        String str = "";
        if (x%2 == 0){
            str = "четное ";
        }else str = "нечетное ";
        String strx = ""+x;
        if (strx.length() == 1){
            System.out.println(str + "однозначное число");
        }
        if (strx.length() == 2){
            System.out.println(str + "двузначное число");
        }
        if (strx.length() == 3){
            System.out.println(str + "трехзначное число");
        }
    }
}
