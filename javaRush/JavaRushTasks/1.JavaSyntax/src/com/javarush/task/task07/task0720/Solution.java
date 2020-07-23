package com.javarush.task.task07.task0720;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        for(int i =1;i<=n;i++){
            list.add(reader.readLine());
        }
        for(int i=1;i<=m;i++){
            String s = list.get(0);
            list.remove(0);
            list.add(s);
        }
        for(String text:list){
            System.out.println(text);
        }


        //напишите тут ваш код
    }
}
