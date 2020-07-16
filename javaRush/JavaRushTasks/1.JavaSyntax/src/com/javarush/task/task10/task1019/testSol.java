package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class testSol {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (true) {
            String i = reader.readLine();
            if (i.isEmpty()) break;
            int id = Integer.parseInt(i);
            String name = reader.readLine();
            map.put(name, id);
        }
        map.forEach((key, value) -> System.out.println(value + " " + key));
    }
}
