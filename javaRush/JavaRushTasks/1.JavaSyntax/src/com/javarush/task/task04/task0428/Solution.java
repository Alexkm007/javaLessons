package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = 0;
        for(int i=0;i<=2;i++){
            int x = Integer.parseInt(reader.readLine());
            if(x>0){
                k++;
            }
        }
        System.out.println(k);
    }
}
