package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list= new ArrayList<Integer>();
        int lenght = 1;
        int maxlenght = 1;
        for (int i=0;i<=9;i++){

            Integer k = Integer.parseInt(reader.readLine());
            list.add(k);
            if (i==0) {
                continue;
            }

            if (k.equals(list.get(i-1))){
                lenght++;
            }else{
                lenght = 1;
            }
            if (lenght>maxlenght){
                maxlenght = lenght;
            }

        }
        if (maxlenght==0){
          maxlenght = 1;
        }

        System.out.println(maxlenght);
    }
}