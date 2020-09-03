package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String path = rd.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        path = rd.readLine();
        zipFileManager.createZip(Paths.get(path));
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
