package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        for(int i =1;i<=x;i++){
            String s = "";
            for(int l = 1;l<=y;l++){
                s +=8;
            }
            System.out.println(s.trim());
        }

    }
}
