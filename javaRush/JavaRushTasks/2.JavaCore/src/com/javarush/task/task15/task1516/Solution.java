package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

//    {
//        intVar = 1;
//        doubleVar = 2;
//        DoubleVar = 1d;
//        booleanVar = true;
//        ObjectVar = new Object();
//        ExceptionVar = new Exception();
//        StringVar = "Привет";
//    }

    public static void main(String[] args) {
        Solution sol= new Solution();
        System.out.println(sol.intVar);
        System.out.println(sol.doubleVar);
        System.out.println(sol.DoubleVar);
        System.out.println(sol.booleanVar);
        System.out.println(sol.ObjectVar);
        System.out.println(sol.ExceptionVar);
        System.out.println(sol.StringVar);
    }
}
