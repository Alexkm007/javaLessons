package com.javarush.task.task08.task0815;

import java.lang.reflect.Array;
import java.util.*;

/* 
Перепись населения
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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        if (!map.containsValue(name)) {
            return 0;
        }
        int t = 0;
        List<String> v = new ArrayList(map.values());
        for (int i = 0; i <= v.size() - 1; i++) {
            if (name == v.get(i)) {
                t++;
            }
        }
        return t;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        if (!map.containsKey(lastName)) {
            return 0;
        } else {
            return 1;
        }

    }

    public static void main(String[] args) {

    }
}
