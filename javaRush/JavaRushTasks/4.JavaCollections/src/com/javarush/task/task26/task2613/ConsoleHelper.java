package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bis.readLine();
    }

    public static String askCurrencyCode() throws IOException {
        writeMessage("Введите код валюты");
        String code = "";
        while (true){
            code = readString();
            if(code.length()==3){
                break;
            }
            writeMessage("Не корректный ввод, введите код валюты:");
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws IOException {
        writeMessage("Введите номинал и количество банкнот:");

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Ошибка, повторите ввод:");
                continue;
            }
            if (nominal <= 0 || total <= 0 || input.length > 2) {
                writeMessage("Ошибка, повторите ввод:");
                continue;
            }
            break;
        }
        return input;
    }

}
