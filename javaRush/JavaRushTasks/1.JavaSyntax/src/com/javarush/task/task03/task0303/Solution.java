package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(1000,90));
        System.out.println(convertEurToUsd(1100,85));
    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        return eur*exchangeRate;

    }
}
