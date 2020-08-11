package com.javarush.task.task14.task1419;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new IOException());
        exceptions.add(new EOFException());
        exceptions.add(new IllegalStateException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new ClassCastException());
        exceptions.add(new EmptyStackException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new IllegalMonitorStateException());
        //напишите тут ваш код

    }
}
