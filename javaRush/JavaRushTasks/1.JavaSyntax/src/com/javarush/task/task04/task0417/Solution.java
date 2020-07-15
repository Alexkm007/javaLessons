package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int z = Integer.parseInt(reader.readLine());

        if (x==y & y==z){
            System.out.println(x +" "+y+" "+z);
            return;
        }
        if (x==y){
            System.out.println(x +" "+y);
        }
        if (x==z){
            System.out.println(x +" "+z);
        }
        if (z==y){
            System.out.println(z +" "+y);
        }
    }
}