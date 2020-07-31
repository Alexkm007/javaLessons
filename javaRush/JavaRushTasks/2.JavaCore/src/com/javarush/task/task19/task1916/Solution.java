package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {



//        String file1 = readFile("c:\\test\\1.txt");
//        String file2 = readFile("c:\\test\\2.txt");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = readFile(rd.readLine());
        String file2 = readFile(rd.readLine());
        rd.close();

        String[] files1 = file1.split("\\r\\n");
        String[] files2 = file2.split("\\r\\n");

        int a = 0;
        for (int i = 0; i < files1.length; i++) {
            int b = returnNuber(files1[i]);
            if(a>=files2.length-1){
                LineItem line = new LineItem(Type.REMOVED,files1[i]);
                lines.add(line);
            }
            for(; a< files2.length;a++){
                if(files1[i].equals(files2[a])){
                    LineItem line = new LineItem(Type.SAME,files1[i]);
                    lines.add(line);
                    a++;
                    break;
                }
                int c = returnNuber(files2[a]);
                if(c<b){
                    LineItem line = new LineItem(Type.ADDED,files2[a]);
                    lines.add(line);
                    continue;
                }else {
                    LineItem line = new LineItem(Type.REMOVED,files1[i]);
                    lines.add(line);
                    break;
                }
            }
        }
        if(a<files2.length-1){
            a++;
            LineItem line = new LineItem(Type.ADDED,files2[a]);
            lines.add(line);
        }

//        for(LineItem ls:lines){
//            System.out.println(ls.type + ls.line);
//        }
    }

    public static String readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        StringBuffer str = new StringBuffer();

        while (fr.ready()) {
            char [] a = new char[10];
            fr.read(a);
            str.append(new String(a));
        }
        fr.close();
        return str.toString();
    }

    public static int returnNuber(String str){
        Pattern p = Pattern.compile("\\d+\\b");
        Matcher m = p.matcher(str.toString());
        StringBuilder strb = new StringBuilder();
        while (m.find()){
            strb.append(m.group());
        }
        return Integer.parseInt(strb.toString());

    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
