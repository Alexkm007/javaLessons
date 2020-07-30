package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = rd.readLine();
            secondFileName = rd.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String fullFileName;
        private StringBuffer content;

        {
            content = new StringBuffer();
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            if (content == null){
                return " ";
            }
            return content.toString();
        }

        @Override
        public void run() {
            try {
                FileReader reader = new FileReader(fullFileName);
                BufferedReader buffer = new BufferedReader(reader);
                while (buffer.ready()) {
                    content.append(buffer.readLine());
                    content.append(" ");
                }
                buffer.close();
                reader.close();
            } catch (Exception e) {
            }
        }
    }

}
