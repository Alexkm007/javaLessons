package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader rd=  new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine())));
        List<Integer> list = new ArrayList<Integer>();
        String str;
        while(( str = fr.readLine()) != null){
            int x = Integer.parseInt(str);
            if(x%2==0){
                list.add(x);
            }
        }
        fr.close();
        rd.close();
        Collections.sort(list);
        for(int i:list){
            System.out.println(i);
        }
    }
}
