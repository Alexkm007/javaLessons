package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Integer max = 1;
        FileInputStream is = new FileInputStream(rd.readLine());
        while (is.available()>0){
            Integer data = is.read();
            if(map.containsKey(data)){
                Integer val = map.get(data);
                val++;
                map.put(data,val);
                if(val>max){
                    max = val;
                }

            }else {
                map.put(data,1);
            }
        }
        String out = "";
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            Integer value = pair.getValue();
            if(value.equals(max)){
                out = out+pair.getKey() + " ";
            }

        }
        is.close();
        System.out.println(out.trim());
    }
}
