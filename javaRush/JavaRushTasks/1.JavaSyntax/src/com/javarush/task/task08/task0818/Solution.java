package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("rrr", 100000);
        map.put("ddd", 200);
        map.put("aaa", 800);
        map.put("eee", 300);
        map.put("iii", 100000);
        map.put("ppp", 501);
        map.put("kkk", 400);
        map.put("nnn", 594);
        map.put("bbb", 392);
        map.put("ccc", 9090);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry <String,Integer> pair = iterator.next();
            int i  = pair.getValue();
            if(i<500){
                iterator.remove();
            }

        }

    }

    public static void main(String[] args) {

    }
}