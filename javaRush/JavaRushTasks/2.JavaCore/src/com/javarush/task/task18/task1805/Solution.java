package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();

        FileInputStream fis = new FileInputStream(name);
        TreeSet<Integer> set = new  TreeSet<Integer>();

        while (fis.available()>0){
            set.add(fis.read());
        }
        fis.close();
        String s = "";
        for(Integer a:set){
            s +=a+" ";
        }
        System.out.println(s.trim());
    }
}
