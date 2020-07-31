package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        ByteArrayOutputStream text = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(text);
        System.setOut(myStream);
        testString.printSomething();
        FileOutputStream fileInputStream = new FileOutputStream(rd.readLine());
        String str = text.toString();
        fileInputStream.write(str.getBytes());
        System.setOut(out);
        System.out.println(str);
        fileInputStream.close();
        rd.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

