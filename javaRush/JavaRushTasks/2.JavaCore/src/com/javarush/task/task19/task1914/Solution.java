package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outStream);
        System.setOut(stream);
        testString.printSomething();
        String str = outStream.toString();
        String s[] = str.split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[2]);
        int result = 0;
        switch (s[1]){
            case("+"):
                result = x+y;
                break;
            case ("-"):
                result = x-y;
                break;
            case ("*"):
                result = x*y;
                break;
            default:
                break;
        }


        System.setOut(out);
        testString.printSomething();
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

