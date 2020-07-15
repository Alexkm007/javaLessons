package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        String s = "";
        int i = 0;

        while (i<=strings.size()-1){
           s = strings.get(i);
           if (s.contains("р") & !s.contains("л")){
               strings.remove(i);
               continue ;
           }
            if (s.contains("л") & !s.contains("р")){
                strings.add(i+1,s);
                i+=2;
                continue ;
            }
           i++;

        }

        return strings;
    }
}