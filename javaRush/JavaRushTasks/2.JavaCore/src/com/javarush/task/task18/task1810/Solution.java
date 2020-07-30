package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            FileInputStream fs = new FileInputStream(rd.readLine());
            if(fs.available()<1000){
                fs.close();
                throw new DownloadException();
            }

        }

    }

    public static class DownloadException extends Exception {

    }
}
