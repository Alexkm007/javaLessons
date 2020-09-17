package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> monthMap = new HashMap<>();
        monthMap.put("January",1);
        monthMap.put("February",2);
        monthMap.put("March",3);
        monthMap.put("April",4);
        monthMap.put("May",5);
        monthMap.put("June",6);
        monthMap.put("July",7);
        monthMap.put("August",8);
        monthMap.put("September",9);
        monthMap.put("October",10);
        monthMap.put("November",11);
        monthMap.put("December",12);

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String month = rd.readLine();
        System.out.printf(month + " is the " + monthMap.get(month) + " month");
    }
}
