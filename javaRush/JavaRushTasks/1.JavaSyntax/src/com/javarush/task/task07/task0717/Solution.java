package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);
        for (String text : result) {
            System.out.println(text);
        }
        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        for (String text : list) {
            newList.add(text);
            newList.add(text);
        }
        return newList;
    }
}
