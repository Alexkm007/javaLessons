package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream is = new FileInputStream(reader.readLine());
        int value = 0;
        while (is.available()>0){
            int data = is.read();
            if(data == 44){
                value++;
            }
        }
        is.close();
        System.out.println(value);

    }
}
