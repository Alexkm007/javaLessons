package dz2.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(bf.readLine());
            } catch (Exception e) {
                printMessage("ВВедено не корректное число, попробуйте еще раз");
            }
        }
    }

    public static String readString() throws IOException {
        return bf.readLine();
    }

    public static Sex readSex() throws IOException {
        while (true) {
            String str = readString();
            if (str.equalsIgnoreCase("m")) return Sex.MALE;
            if (str.equalsIgnoreCase("f")) return Sex.FEMALE;
            printMessage("Для ввода пола нужно ввести 'F' или 'M'");
        }
    }

}
