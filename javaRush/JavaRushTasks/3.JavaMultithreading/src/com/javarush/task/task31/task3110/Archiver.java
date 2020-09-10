package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        String path = rd.readLine();
//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
//        path = rd.readLine();
//        zipFileManager.createZip(Paths.get(path));
//        ExitCommand exitCommand = new ExitCommand();
//        exitCommand.execute();
        Operation operation = null;
        while (operation!=Operation.EXIT) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            }catch (WrongZipFileException e){
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            }catch (Exception e){
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
    }

    public static Operation askOperation() throws IOException,WrongZipFileException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage("0 - упаковать файлы в архив");
        ConsoleHelper.writeMessage("1 - добавить файл в архив");
        ConsoleHelper.writeMessage("2 - удалить файл из архива");
        ConsoleHelper.writeMessage("3 - распаковать архив");
        ConsoleHelper.writeMessage("4 - просмотреть содержимое архива");
        ConsoleHelper.writeMessage("5 - выход");
        int x = ConsoleHelper.readInt();
        for (Operation oper:Operation.values()){
            if(oper.ordinal()==x){
                return oper;
            }
        }
        return null;
    }
}
