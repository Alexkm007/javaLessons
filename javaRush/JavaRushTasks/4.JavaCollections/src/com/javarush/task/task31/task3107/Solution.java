package com.javarush.task.task31.task3107;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.jar.Attributes;

/* 
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path file = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(file),Files.isExecutable(file),Files.isDirectory(file),Files.isWritable(file));

        } catch (Exception e){
            fileData = new NullFileData(e);
        }
    }
    public FileData getFileData() {
        return fileData;
    }
}
