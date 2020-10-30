package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("a") + " true");
        System.out.println(isPalindromePermutation("aa") + " true");
        System.out.println(isPalindromePermutation("Aba") + " true");
        System.out.println(isPalindromePermutation("a b a b") + " true");
        System.out.println(isPalindromePermutation("a ss sa b") + " false");
    }

    public static boolean isPalindromePermutation(String s) {
        s = s.toLowerCase().replaceAll(" ","");
        if(s==null || s.length()==0) return false;
        if(s.length()<2)return true;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            String key = s.substring(i, i + 1);
            Integer x = map.get(key);
            if (x == null) {
                x = 1;
            } else {
                x++;
            }
            map.put(key, x);
        }
        int kolNech = 0;
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()%2!=0){
                kolNech++;
            }}
        return kolNech <= 1;
    }
}
