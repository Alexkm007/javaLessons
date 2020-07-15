package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList> ab = new HashMap<String, ArrayList>();
        List<String> list = new ArrayList<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            ArrayList<String> cit = new ArrayList();


            if (!ab.containsKey(city)) {
                cit.add(family);
                ab.put(city, cit);
                continue;
            }
            cit = ab.get(city);
            if (!cit.contains(family)) {
                cit.add(family);
            }
            ab.put(city, cit);

        }

        // Read the house number
        String city = reader.readLine();
        if (!ab.containsKey(city)) {
            return;
        }

        list = ab.get(city);
        if (list.size() == 0) {
            return;
        }

        for (String text : list) {
            System.out.println(text);
        }

    }
}
