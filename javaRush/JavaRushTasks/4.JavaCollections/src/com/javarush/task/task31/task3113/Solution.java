package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/*
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {

    static int countFiles = 0;
    static int countDir = -1;
    static long countBytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(reader.readLine());
        if (!Files.isDirectory(directory)){
            System.out.println(directory.getFileName().toAbsolutePath().toString() + " - не папка");
            return;
        }
        Files.walkFileTree(directory,new Solution());
        System.out.println("Всего папок - " + countDir);
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + countBytes);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countFiles++;
            countBytes+=attrs.size();
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDir++;
        countBytes+=attrs.size();
        return super.preVisitDirectory(dir, attrs);
    }

}
