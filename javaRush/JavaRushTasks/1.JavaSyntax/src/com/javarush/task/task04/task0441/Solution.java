package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int z = Integer.parseInt(reader.readLine());

        if (((x >= y) & (x<=z))|(x>=z & x<=y) ){
            System.out.println(x);
            return;
        }
        if (((y >= x) & (y<=z))|((y>=z & y<=x))){
            System.out.println(y);
            return;
        }
        if (((z >= x) & (z<=y))|((z >= y) & (z<=x))){
            System.out.println(z);
            return;
        }

    }
}
