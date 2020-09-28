package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        try{
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        sw.write(new String(buffer));
        //StringWriter sw = new StringWriter(is);
        return sw;}
        catch (Exception e){
            return sw;
        }
    }
}