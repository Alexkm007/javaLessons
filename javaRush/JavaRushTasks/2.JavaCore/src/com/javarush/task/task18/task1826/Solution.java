package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            return;
        }
        String instr = args[0];
        String input = args[1];
        String output = args[2];

        FileInputStream is = new FileInputStream(input);
        byte[] buff = new byte[is.available()];
        is.read(buff);
        is.close();
        if (instr.equals("-e")) {
            buff = encrypt(buff);
        }else if(instr.equals("-d")){
            buff = dencrypt(buff);
        }
        FileOutputStream fo = new FileOutputStream(output);
        fo.write(buff);
        fo.close();
    }

    public static byte[] encrypt(byte[] buff) {
        for(int i = 0;i <buff.length;i++){
            byte b = buff[i];
            b++;
            buff[i] = b;
        }
        return buff;
    }
    public static byte[] dencrypt(byte[] buff) {
        for(int i = 0;i <buff.length;i++){
            byte b = buff[i];
            b--;
            buff[i] = b;
        }
        return buff;
    }
}
