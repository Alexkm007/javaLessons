package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pos = 0;
        int neg = 0;
        for(int i=0;i<=2;i++){
            int x = Integer.parseInt(reader.readLine());
            if(x>0){
                pos++;
            }else if(x<0){
                neg++;
            }
        }
        System.out.println("количество отрицательных чисел: "+neg);
        System.out.println("количество положительных чисел: "+pos);
    }
}
