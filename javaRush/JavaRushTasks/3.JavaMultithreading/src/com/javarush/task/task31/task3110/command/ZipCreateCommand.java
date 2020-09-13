package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Создание архива.");
        try {
            ZipFileManager zpf = getZipFileManager();
            String strPath = ConsoleHelper.readString();
            Path path = Paths.get(strPath);
            zpf.createZip(path);
            ConsoleHelper.writeMessage("Архив создан.");
        }
        catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
