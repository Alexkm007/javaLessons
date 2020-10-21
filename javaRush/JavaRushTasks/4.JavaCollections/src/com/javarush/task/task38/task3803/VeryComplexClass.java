package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new java.util.Date();
        Integer int1 = (Integer) obj;
    }

    public void methodThrowsNullPointerException() {
        VeryComplexClass ss = null;
        ss.toString();
    }

    public static void main(String[] args) {

    }
}
