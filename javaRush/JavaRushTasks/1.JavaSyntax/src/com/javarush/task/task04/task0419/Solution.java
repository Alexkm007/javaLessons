package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] myArrey = new int[4];
        for (int i = 0; i <= 3; i++) {
            myArrey[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(myArrey);
        System.out.println(myArrey[3]);
    }
}
