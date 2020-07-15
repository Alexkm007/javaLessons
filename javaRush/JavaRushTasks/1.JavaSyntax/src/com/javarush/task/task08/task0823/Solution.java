package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s;
        String string = reader.readLine();
        s = string.toCharArray();
        boolean upp = false;
        for (int i = 0; i <= s.length - 1; i++) {
            if (i == 0 & Character.isAlphabetic(s[i])) {
                s[i] = Character.toTitleCase(s[i]);
            }

            if (Character.isWhitespace(s[i])) {
                upp = true;
            }
            if (!Character.isWhitespace(s[i]) & Character.isAlphabetic(s[i]) & upp) {
                s[i] = Character.toTitleCase(s[i]);
                upp = false;
            }
        }
        string = new String(s);
        System.out.println(string);
        //напишите тут ваш код
    }
}
