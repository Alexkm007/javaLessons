package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(rd.readLine()));
        try  {
            String text = "";
            while (true) {
                String line = rd.readLine();
                if (!line.equals("exit")) {
                    text += line + System.lineSeparator();
                } else {
                    text += line;
                    bw.write(text);
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        bw.close();
    }
}
