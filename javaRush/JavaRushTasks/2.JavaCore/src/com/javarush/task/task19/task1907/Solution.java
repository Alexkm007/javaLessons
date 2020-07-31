package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(rd.readLine());
        rd.close();
        char[] buffer = new char[10];
        StringBuilder str = new StringBuilder();
        while (fr.read(buffer)!=-1){
            str.append(new String(buffer));
            buffer = new char[10];
        }
        fr.close();
        String[] s = str.toString().split("\\bworld\\b");
        System.out.println(s.length-1);
    }
}
