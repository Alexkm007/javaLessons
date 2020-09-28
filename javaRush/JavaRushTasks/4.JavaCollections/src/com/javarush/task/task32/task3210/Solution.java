package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String filename = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

       RandomAccessFile ras = new RandomAccessFile(filename,"rw");

        if(ras.length() > number){
            ras.seek(number);
            byte[] buffer = new byte[text.length()];
            ras.read(buffer,0,text.length());
            String text1 = new String(buffer);
            ras.seek(ras.length());
            if(text.equals(text1)){
                ras.write("true".getBytes());
            } else  ras.write("false".getBytes());

        }else {
            ras.seek(ras.length());
            ras.write("false".getBytes());
        }
        ras.close();

    }
}
