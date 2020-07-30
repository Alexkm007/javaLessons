package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader rcon = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream filein = new FileInputStream(rcon.readLine());
        FileOutputStream fileout = new FileOutputStream(rcon.readLine());
        rcon.close();

        if (filein.available() > 0){
            byte[] data = new byte[filein.available()];
            filein.read(data);

            String[] strArrDouble = new String(data).split(" ");
            StringBuilder resultStrLong = new StringBuilder(data.length);

            for (String strDouble : strArrDouble) {
                resultStrLong.append(Math.round(Double.valueOf(strDouble)));
                resultStrLong.append(" ");
            }
            fileout.write(resultStrLong.toString().getBytes());
        }
        filein.close();
        fileout.close();
    }
}
