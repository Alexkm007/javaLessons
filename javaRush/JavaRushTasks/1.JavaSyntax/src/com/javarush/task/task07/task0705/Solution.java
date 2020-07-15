package com.javarush.task.task07.task0705;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] big = new int[20];
        int[] smal1 = new int[10];
        int[] smal2 = new int[10];

        for (int i=0; i<=19; i++) {
            big[i] =  Integer.parseInt(reader.readLine());
            if (i<=9) {
                smal1[i] = big[i];
            } else {
                smal2[i-10] = big[i];
            }
        }
        for (int i=0; i<=9; i++){
            System.out.println(smal2[i]);
        }

    }
}
