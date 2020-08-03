package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> paer : runtimeStorage.entrySet()) {
            prop.put(paer.getKey(), paer.getValue());
        }
        prop.store(outputStream,"");
        outputStream.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (String key : prop.stringPropertyNames()) {
            runtimeStorage.put(key, prop.getProperty(key));
        }

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
            FileOutputStream out = new FileOutputStream(String.valueOf(fos.getChannel()));
            save(out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
