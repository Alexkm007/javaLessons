package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int index = -1;
        int length = 0;
        for (int i = 1; i <= 10; i++) {
            list.add(reader.readLine());
            length = list.get(i - 1).length();
            if (i == 1) {
                continue;
            }
            if (index == -1) {
                int razn = length - list.get(i - 2).length();
                if (razn < 0) {
                    index = i - 1;
                }
            }
        }
        if(index!=-1){
            System.out.println(index);
        }

    }
}

