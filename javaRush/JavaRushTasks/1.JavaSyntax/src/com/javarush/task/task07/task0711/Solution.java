package com.javarush.task.task07.task0711;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Удалить и вставить
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings  = new ArrayList<String>();
        for (int i=0;i<=4;i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            strings.add(reader.readLine());
        }

        for(int i=0;i<=12;i++){
            String s = strings.get(strings.size()-1);
            strings.remove(strings.size()-1);
            strings.add(0,s);
        }

        for (int i=0; i<=strings.size()-1;i++){
            System.out.println(strings.get(i));
        }


    }
}
