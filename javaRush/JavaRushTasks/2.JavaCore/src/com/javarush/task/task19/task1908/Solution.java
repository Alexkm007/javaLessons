package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(rd.readLine()));
        StringBuilder str = new StringBuilder();
        while (fr.ready()){
            str.append(new String(fr.readLine()));
        }
        fr.close();
        Pattern p = Pattern.compile("(\\b)\\d+(\\s|\\b)");
        Matcher m = p.matcher(str.toString());
        str = new StringBuilder();
        while (m.find()){
            str.append(m.group());
        }
        BufferedWriter fw =new BufferedWriter(new FileWriter(rd.readLine()));
        rd.close();
        fw.write(str.toString().trim());
        fw.close();
    }
}
