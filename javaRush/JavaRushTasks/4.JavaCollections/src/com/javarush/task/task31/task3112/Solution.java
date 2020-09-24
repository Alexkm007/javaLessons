package com.javarush.task.task31.task3112;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {

        URL url=new URL(urlString);
        InputStream inputStream=url.openStream();

        Path tmp=Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream,tmp);

        String fieName=urlString.substring(urlString.lastIndexOf("/"));
        Path destPath=Paths.get(downloadDirectory.toString(), fieName);
        Files.move(tmp,destPath);

        return destPath;
    }
}
