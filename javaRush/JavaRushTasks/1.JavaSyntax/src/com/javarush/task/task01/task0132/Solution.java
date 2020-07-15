package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int isot = number/100;
        int ides = number%100;
        int ikold = ides/10;
        int ost = ides%10;
        return isot + ikold + ost;

    }
}