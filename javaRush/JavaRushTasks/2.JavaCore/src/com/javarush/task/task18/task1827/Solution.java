package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            return;
        }
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];


        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        int id = returnMaxId(name) + 1;
        FileOutputStream fs = new FileOutputStream(new File(name), true);

        productName = cheklengt(productName, 30);
        price = cheklengt(price, 8);
        quantity = cheklengt(quantity, 4);
        String ids = cheklengt("" + id, 8);
        String strout = "\n" + ids + productName + price + quantity;
        fs.write(strout.getBytes());
        fs.close();

    }

    public static String cheklengt(String str, int len) {
        if (str.length() > len) {
            str = str.substring(0, len - 1);
        } else {
            for (int i = str.length(); i <= len - 1; i++) {
                str = str + " ";
            }
        }
        return str;
    }

    public static int returnMaxId(String name) throws IOException {
        FileInputStream fs = new FileInputStream(name);
        int maxId = 0;
        if (fs.available() > 0) {
            byte[] buf = new byte[fs.available()];
            fs.read(buf);
            fs.close();
            String data = new String(buf);
            String[] lines = data.split("[\\r\\n]+");
            for (String line : lines) {
                String strid = line.substring(0, 8).trim();
                int id = Integer.parseInt(strid);
                if (maxId < id) {
                    maxId = id;
                }
            }
        }
        return maxId;
    }

}
