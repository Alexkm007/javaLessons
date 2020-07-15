package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (String text : list) {
            char[] symbls = text.toCharArray();
            for (Character symbl : symbls) {
                if (alphabet.contains(symbl)) {
                    if (map.containsKey(symbl)) {
                        Integer i = map.get(symbl);
                        i++;
                        map.put(symbl, i);
                    } else {
                        map.put(symbl, 1);
                    }
                }
            }
        }
        Integer i;
        for (Character sybol : alphabet) {
            i = 0;
            if (map.containsKey(sybol)) {
                i = map.get(sybol);
            }
            System.out.println(sybol + " " + i);
        }
        // напишите тут ваш код
    }
}
