package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        if(n==1)return true;
        for (int i = 1; i <= n; i*=3) {
            if (i == n) return true;

        } return false;
    }
}
