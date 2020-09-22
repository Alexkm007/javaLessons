package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/
public class Solution {

    private Map<String, File> files = new TreeMap<>();

    public static void main(String[] args) throws IOException {
//        args = new String[2];
//        args[0] = "C:\\test\\test3101";
//        args[1] = "C:\\test\\out\\allFilesContent.txt";
//        if (args.length < 2) {
//            return;
//        }
        File in = new File(args[1]);
        File out = new File(in.getParent() + File.separator + "allFilesContent.txt");
        if (in.exists()) {
            FileUtils.renameFile(in, out);}

        Solution sol = new Solution();
        sol.writeDataInFiles(new File(args[0]));
        sol.writeDataInRezultFile(out);
    }

    public void writeDataInFiles(File path) {
        for (File file : path.listFiles()) {
            if (file.getName().equals("allFilesContent.txt")) {
                continue;
            }
            if (file.isDirectory()) {
                writeDataInFiles(file);
                continue;
            }
            if (file.length() <= 50) {
                files.put(file.getAbsolutePath(), file);
            }
        }
    }

    public void writeDataInRezultFile(File out) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));

        for (Map.Entry<String, File> entry : files.entrySet()) {
            BufferedReader br = new BufferedReader(new FileReader(entry.getKey()));
            while (br.ready()) {
                bw.write(br.readLine());
            }
            br.close();
            bw.write("\n");
        }
        bw.close();
    }

}
