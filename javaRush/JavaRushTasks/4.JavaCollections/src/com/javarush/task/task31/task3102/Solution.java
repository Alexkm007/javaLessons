package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> filesTree = new ArrayList<>();
        ArrayDeque<String> paths = new ArrayDeque<String>();
        paths.add(root);
        while (paths.size() > 0) {
            File file = new File(paths.removeFirst());
            if(!file.isDirectory()) continue;
            List<File> fileList = new ArrayList<>();
            fileList = Arrays.asList(file.listFiles());
            if (fileList == null || fileList.size() == 0) continue;
            for (File fileAdd : fileList) {
                if (fileAdd.isDirectory()) {
                    paths.add(fileAdd.getAbsolutePath());
                    continue;
                }
                filesTree.add(fileAdd.getAbsolutePath());
            }
        }
        return filesTree;
    }

    public static void main(String[] args) throws IOException {
    }
}
