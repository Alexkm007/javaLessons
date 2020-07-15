package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        data = dateFormat.parse(reader.readLine());
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String str = dateFormat2.format(data);
        System.out.println("" + str.toUpperCase());
    }
}
