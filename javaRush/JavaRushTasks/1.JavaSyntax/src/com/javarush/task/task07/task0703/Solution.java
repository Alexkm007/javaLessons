package com.javarush.task.task07.task0703;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[10];
        int[] lengts = new int[10];
        int i = 0;
        while (i <=9){
               strings[i] = reader.readLine();
               lengts[i] = strings[i].length();
               i++;
        }

        i = 0;
        while (i <=9){
                System.out.println(lengts[i]);
                i++;
        }

    }
}
