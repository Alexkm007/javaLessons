package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        float y = 0;
        int i = 0;
        float z = 0;

        while (x!=-1){
            x = Integer.parseInt(reader.readLine());
            if (x==-1){
                break;
            }
            y+=x;
            i++;
        }
        z = y/i;
        System.out.println(z);
    }
}

