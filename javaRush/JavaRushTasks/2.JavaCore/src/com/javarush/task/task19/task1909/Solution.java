package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(rd.readLine()));
        rd.close();
        while (fr.ready()) {
            fw.write(fr.readLine().replace(".", "!")+System.lineSeparator());
        }
        fr.close();
        fw.close();
    }
}
