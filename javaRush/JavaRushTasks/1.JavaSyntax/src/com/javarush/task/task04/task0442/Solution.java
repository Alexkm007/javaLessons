package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while (true) {
            int k = Integer.parseInt(reader.readLine());
            if (k == -1) {
                i += k;
                break;
            }
            i += k;
        }
        System.out.println(i);
    }
}
