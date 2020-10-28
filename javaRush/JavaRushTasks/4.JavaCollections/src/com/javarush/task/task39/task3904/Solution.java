package com.javarush.task.task39.task3904;

import java.util.Arrays;
import java.util.List;

/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        long x = 1;
        long y = 1;
        long z = 0;
        long sum = 0;
        for (int j = 2; j <= n; j++) {
            sum = x + y + z;
            z = y;
            y = x;
            x = sum;
        }
        return sum;
    }
}

