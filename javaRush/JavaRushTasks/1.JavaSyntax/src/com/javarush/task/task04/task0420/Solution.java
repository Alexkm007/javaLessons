package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int z = Integer.parseInt(reader.readLine());
        if (x >= y & x >= z & y >=z){
            System.out.println(x + " " + y + " " + z);
            return;
        }
        if (x >= y & x >= z & z >=y){
            System.out.println(x + " " + z + " " + y);
            return;
        }
        if (y >= x & y >= z & x >=z){
            System.out.println(y + " " + x + " " + z);
            return;
        }
        if (y >= x & y >= z & z >=x){
            System.out.println(y+ " " + z + " " + x);
            return;
        }
        if (z >= x & z >= y & x >=y){
            System.out.println(z + " " + x + " " + y);
            return;
        }
        if (z >= x & z >= y & y >=x){
            System.out.println(z + " " + y + " " + x);
            return;
        }

    }
}
