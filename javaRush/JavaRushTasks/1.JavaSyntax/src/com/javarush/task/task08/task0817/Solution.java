package com.javarush.task.task08.task0817;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("иванов", "иван");
        map.put("петров", "сергей");
        map.put("сершеев", "петр");
        map.put("крукаа", "Алексей");
        map.put("крукаа2", "Алексей");
        map.put("крукаа4", "Алексей");
        map.put("сершеев2", "петр");
        map.put("сершеев3", "петр");
        map.put("сершеев4", "петр");
        map.put("сершеев5", "петр");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, Integer> mapdel = new HashMap<String, Integer>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            if (mapdel.containsKey(value)) {
                int i = mapdel.get(value);
                i++;
                mapdel.put(value, i);

            } else {
                mapdel.put(value, 1);
            }

        }
        for (Map.Entry<String, Integer> pair : mapdel.entrySet()) {
            int i = pair.getValue();
            if (i > 1) {
                removeItemFromMapByValue(map, pair.getKey());
            }

        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
    }
}
