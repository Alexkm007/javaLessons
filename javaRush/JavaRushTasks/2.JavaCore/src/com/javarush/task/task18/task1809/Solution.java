package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name1 = bf.readLine();
        String name2 = bf.readLine();
        FileInputStream is = new FileInputStream(name1);
        FileOutputStream os = new FileOutputStream(name2);
        int count = is.available();
        byte[] buffer = new byte[count];
        is.read(buffer);
        for(int i = buffer.length-1;i>=0;i--){
            os.write(buffer[i]);
        }
        is.close();
        os.close();
    }
}
