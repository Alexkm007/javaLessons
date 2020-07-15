package com.javarush.task.task07.task0706;

import org.omg.CORBA.ShortSeqHelper;

import java.io.IOException;
import  java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] homes = new int[15];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int chet,nechet;
        chet = 0;
        nechet = 0;
        for (int i = 0; i <=14; i++){
            homes[i] = Integer.parseInt(reader.readLine());
            if (i%2 == 0){
                chet+= homes[i];
            } else {
                nechet+= homes[i];
            }
        }
        if (chet >= nechet){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }  else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }

    }
}
