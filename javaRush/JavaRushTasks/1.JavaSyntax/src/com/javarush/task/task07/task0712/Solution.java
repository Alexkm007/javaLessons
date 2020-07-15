package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> strings = new ArrayList<String>();
        int min = 0;
        int max = 0;
        String s = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<=9;i++) {
            s = reader.readLine();
            if(i==0) {
                min =s.length();
            }
            strings.add(s);
            if (min>s.length()){
                min = s.length();
            }
            if(max<s.length()){
                max = s.length();

            }

        }
        s = "";
        for (int i=0;i<=9;i++){
            s = strings.get(i);
            if ((s.length() == min)||(s.length() == max)){
                System.out.println(s);
                break;
            }
        }

        }
}
