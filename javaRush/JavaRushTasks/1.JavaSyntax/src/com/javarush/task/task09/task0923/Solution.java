package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //Написать тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArray = s.toCharArray();
        String vowels = "";
        String consonants = "";

        for (int i=0;i<charArray.length;i++) {
            if (isVowel(charArray[i])) {
                vowels = vowels + charArray[i]+ " ";
            }
            else if (charArray[i]==' ')  { continue;}
            else consonants = consonants + charArray[i] + " ";
        }

        System.out.println(vowels);
        System.out.println(consonants);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}