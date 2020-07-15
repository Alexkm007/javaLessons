package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> string = new ArrayList<String>();
        string.add("мама");
        string.add("именно");
        string.add("мыла");
        string.add("именно");
        string.add("раму");
        string.add("именно");
        for (int i=0;i<=string.size()-1;i++){
            System.out.println(string.get(i));
        }

    }
}
