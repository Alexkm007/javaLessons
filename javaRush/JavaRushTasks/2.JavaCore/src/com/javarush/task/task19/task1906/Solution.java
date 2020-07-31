package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(rd.readLine());
        FileWriter fw = new FileWriter(rd.readLine());
        rd.close();
        int i = 1;
        while (fr.ready()){
            int data;
            data = fr.read();
            if(i%2!=0){
                i++;
                continue;
            }
            fw.write(data);
            i++;
        }
        fr.close();
        fw.close();


    }
}
