package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream ir = new FileInputStream(new File(args[0].toString()));
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[ir.available()];
        while (ir.available() > 0){

            ir.read(buffer);
            sb.append(new String(buffer,Charset.forName("Windows-1251")));

        }
        ir.close();
        FileWriter fr = new FileWriter(new File(args[1].toString().trim()));
        fr.write(new String(sb.toString().getBytes()));
        fr.close();
    }
}
