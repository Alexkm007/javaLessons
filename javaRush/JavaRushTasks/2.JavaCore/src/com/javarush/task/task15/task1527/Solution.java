package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String delimetr;
        delimetr = "\\?";
        String[] lstr = url.split(delimetr);
        if (lstr.length <= 1) {
            return;
        }
        String param = lstr[1];
        delimetr = "&";
        lstr = param.split(delimetr);
        ArrayList<String> alerts = new ArrayList<>();
        String out = "";
        for (String text : lstr) {
            delimetr = "=";
            String[] par = text.split(delimetr);
            if (par.length > 0) {
                out +=par[0] + " ";
                if (par[0].equals("obj")) {
                    alerts.add(par[1]);
                }
            }
        }
        System.out.println(out.trim());
        for(String text:alerts){
            try {
                double d= Double.parseDouble(text);
                alert(d);
            }catch (Exception e){
                alert(text);
            }


        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
