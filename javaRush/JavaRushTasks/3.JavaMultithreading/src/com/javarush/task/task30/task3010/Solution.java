package com.javarush.task.task30.task3010;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            for (int i = 2; i < 37; i++) {
                if (isNumber(args[0], i)) {
                    System.out.println(i);
                    break;
                } else {
                    if (i == 36) System.out.println("incorrect");
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean isNumber(String arg, int radix) {
        boolean result = false;
        try {
            new BigDecimal(new BigInteger(arg, radix));
            result = true;
        } catch (Exception e) {
        }
        return result;
    }
}