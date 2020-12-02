package homework6.part1;

import java.io.*;
import java.util.Locale;

public class ReadFile implements ReturningData {

    private String path;

    public ReadFile() {
    }

    public ReadFile(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private static String returnOnlyLetter(String rowData) {
        StringBuilder sb = new StringBuilder();
        char[] chars = rowData.toCharArray();
        for (char ch : chars) {
            if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String returnData() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            while (bf.ready()) {
                sb.append(returnOnlyLetter(bf.readLine().toLowerCase()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
