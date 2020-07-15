package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        if ((x < 1)|(x > 7)){
            System.out.println("такого дня недели не существует");
            return;
        }
        switch (x) {
            case 1: System.out.println("понедельник");
                break;
            case 2: System.out.println("вторник");
                break;
            case 3: System.out.println("среда");
                break;
            case 4: System.out.println("четверг");
                break;
            case 5: System.out.println("пятница");
                break;
            case 6: System.out.println("суббота");
                break;
            case 7: System.out.println("воскресенье");
                break;
        }


    }
}