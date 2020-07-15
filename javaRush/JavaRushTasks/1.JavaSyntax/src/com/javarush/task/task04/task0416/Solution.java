package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float x = Float.parseFloat(reader.readLine());
        if (x<=5.0){
            System.out.println(min6(x));
        }else System.out.println(big6(x));

    }
    public static String min6(float x){
        if (x < 3 | x == 5){
            return "зелёный";
        }
        if (x >= 3 & x < 4){
            return "жёлтый";
        }
        if (x >= 4 & x < 5)
        {
            return "красный";
        }
        return "хз";
    }
    public static String big6(float x){
        float z = x%5;
        return min6(z);
    }

}