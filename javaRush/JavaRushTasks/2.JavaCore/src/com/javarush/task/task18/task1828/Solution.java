package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static List<Map<String, String>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            return;
        }

        String nameFile = returnNameFile();
        List<String> listData = returnFileData(nameFile);
        for (String s : listData) {
            list.add(convertToMap(s));
        }

        if (args.length > 2) {
            Map row = new HashMap<String, String>();
            row.put("id", args[1].trim());
            row.put("product", args[2]);
            row.put("price", args[3]);
            row.put("quantity", args[4]);
            updateRows(row);
        } else {
            removeRow(args[1]);
        }
        //System.out.println(list);
        saveFile(nameFile);
    }

    public static void updateRows(Map<String, String> row) {
        int id = -1;

        for (Map m : list) {
            if (m.get("id").equals(row.get("id"))) {
                id = list.indexOf(m);
            }
        }
        if (id > 0) {
            list.set(id, row);
        } else {
            //System.out.println("Не нашли такую запись: " + row);
        }
    }

    public static  void saveFile(String name) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(name));
        for(Map<String,String>row:list){
            String srow = rowToString(row);
           bw.write(srow+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static String rowToString(Map<String,String>row){
        String s = String.format("%-8s%-30s%-8s%-4s",row.get("id"),
                row.get("product"),row.get("price"),row.get("quantity"));
        return s;
    }

    public static List<String> returnFileData(String name) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader rd = new BufferedReader(new FileReader(name));
        while (rd.ready()) {
            list.add(rd.readLine());
        }
        rd.close();
        return list;
    }

    public static String returnNameFile() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return rd.readLine();
    }

    public static Map<String, String> convertToMap(String s) {

        String id = s.substring(0, 8).trim();
        String product = s.substring(8, 38).trim();
        String price = s.substring(38, 46).trim();
        String quantity = s.substring(46, 48).trim();

        Map<String, String> row = new HashMap<>();
        row.put("id", id);
        row.put("product", product);
        row.put("price", price);
        row.put("quantity", quantity);
        return row;

    }

    public static void removeRow(String id) {
        int i = -1;

        for (Map m : list) {
            if (m.get("id").equals(id)) {
                i = list.indexOf(m);
            }
        }

        if(i>0){
            list.remove(i);
        }else{
           // System.out.println("Не нашли такую запись: " + i);
        }

    }

}
