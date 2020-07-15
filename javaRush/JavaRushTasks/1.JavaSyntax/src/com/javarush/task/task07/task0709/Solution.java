package com.javarush.task.task07.task0709;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        int min = 0;
        String s = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<=4;i++) {
            s = reader.readLine();
            if(i==0) {
                min =s.length();
            }
            strings.add(s);
            if (min>s.length()){
                min = s.length();
            }
        }
        s = "";
        for (int i=0;i<=4;i++){
            s = strings.get(i);
            if (s.length() == min){
                System.out.println(s);
            }
        }


    }
}
