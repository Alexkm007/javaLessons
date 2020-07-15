package com.javarush.task.task05.task0532;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int iter = Integer.parseInt(reader.readLine());
        if (iter<= 0) return;
        int i = 1;


        while (i<=iter) {
            int tek = Integer.parseInt(reader.readLine());
            if (i==1){
               maximum = tek;

            }else{
                if (tek > maximum) {
                    maximum = tek;
                }
            }
            i++;
        }
        System.out.println(maximum);
    }
}
