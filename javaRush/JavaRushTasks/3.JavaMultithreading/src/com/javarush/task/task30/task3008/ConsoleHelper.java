package com.javarush.task.task30.task3008;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        boolean readed = false;
        String line = "";
        while (!readed) {
            try {
                line = rd.readLine();
                readed = true;
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return line;
    }

    public static int readInt() throws NumberFormatException, IOException {
        int x = 0;
        boolean readed = false;
        while (!readed) {
            try {
                x = Integer.parseInt(readString());
                readed = true;
            } catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return x;
    }

}
