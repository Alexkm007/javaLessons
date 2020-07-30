package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream is = new FileInputStream(reader.readLine());
        int max = Integer.MIN_VALUE;
        while (is.available()>0){
            int data = is.read();
            if (data>max){
                max = data;
            }
        }
        is.close();
        System.out.println(max);
    }
}
