package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>();
       for(T o:elements){
           arrayList.add(o);
       }
        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet();
        for(T o:elements){
            hashSet.add(o);
        }
        return hashSet;
    }

    public static <K,V>HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if(keys.size() != values.size()){
            throw new IllegalArgumentException();
        }

        HashMap<K,V> map = new HashMap<>();
        for(int i =0;i<keys.size();i++){
            map.put(keys.get(i),values.get(i));
        }
        return map;
    }
}
