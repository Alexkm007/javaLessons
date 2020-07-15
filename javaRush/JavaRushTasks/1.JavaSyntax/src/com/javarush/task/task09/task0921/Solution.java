package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            while (true) {
                String str = reader.readLine();
                if (str.isEmpty()) {
                    printArrey(list);
                    break;
                }
                int i = Integer.parseInt(str);
                list.add(i);
            }
        } catch (Exception e) {
            printArrey(list);
        }
    }

    public static void printArrey(ArrayList<Integer> list) {
        for (Integer x : list) {
            System.out.println(x);
        }

    }
}
