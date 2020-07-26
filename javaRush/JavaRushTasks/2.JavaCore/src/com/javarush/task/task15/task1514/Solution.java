package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put((double) 1,"один");
        labels.put((double) 2,"два");
        labels.put((double) 3,"три");
        labels.put((double) 4,"четыре");
        labels.put((double) 5,"Пять");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
