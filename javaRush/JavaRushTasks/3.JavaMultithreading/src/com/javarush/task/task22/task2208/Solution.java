package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params1 = new HashMap<String,String>();
        params1.put("name","Ivanov");
        params1.put("country","Ukraine");
        params1.put("city","Kiev");
        params1.put("age",null);
        System.out.println(getQuery(params1));
    }

    public static String getQuery(Map<String, String> params) {
        Set<String> keys = params.keySet();
        StringBuilder sb = new StringBuilder();
        for (String str : keys) {
            if (params.get(str) != null) {
                if (!params.get(str).equals("null")) {
                    sb.append(str).append(" = '").append(params.get(str))
                            .append("' and ");
                }
            }
        }
        if (sb.length() != 0) {
            sb.delete(sb.lastIndexOf(" and "), sb.length());
        }
        return sb.toString();

    }
}
