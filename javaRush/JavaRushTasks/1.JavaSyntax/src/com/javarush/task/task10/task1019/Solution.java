package com.javarush.task.task10.task1019;

/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();

        while (true) {
           try {
               int id = Integer.parseInt(reader.readLine());
               String name = reader.readLine();
  //             if(name.isEmpty()){
  //                 break;
  //             }
               additems(map,name,id);
           } catch (Exception e) {
               break;
           }

        }

        for (Map.Entry<String, ArrayList<Integer>> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            ArrayList<Integer> value = pair.getValue();                  //значение
            for(Integer i:value){
                System.out.println(i + " " + key);
            }

        }


        //System.out.println("Id=" + id + " Name=" + name);
    }

    public static void additems(Map<String, ArrayList<Integer>> map,String name, int id){

        if(map.containsKey(name)){
            ArrayList<Integer> list = map.get(name);
            list.add(id);
            map.put(name,list);
        }else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(id);
            map.put(name,list);
        }

    }


}
