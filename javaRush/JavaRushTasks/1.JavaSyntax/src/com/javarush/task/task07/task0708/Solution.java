package com.javarush.task.task07.task0708;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        int max = 0;
        String s = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<=4;i++) {
            s = reader.readLine();
            strings.add(s);
            if (max<s.length()){
                max = s.length();
            }
        }
        s = "";
        for (int i=0;i<=4;i++){
            s = strings.get(i);
            if (s.length() == max){
                System.out.println(s);
            }
        }


    }
}
