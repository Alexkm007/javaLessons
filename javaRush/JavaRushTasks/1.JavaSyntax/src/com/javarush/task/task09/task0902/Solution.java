package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) {
        String str = method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String name =  "";
        for (StackTraceElement element : stackTraceElements){

            if(name == "method1"){
                name = element.getMethodName();
                //System.out.println(name);
                return name;
            }
            name = element.getMethodName();
        }
        return name;

    }

    public static String method2() {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String name =  "";
        for (StackTraceElement element : stackTraceElements){

            if(name == "method2"){
                name = element.getMethodName();
                //System.out.println(name);
                return name;
            }
            name = element.getMethodName();
        }
        return name;
    }

    public static String method3() {
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String name =  "";
        for (StackTraceElement element : stackTraceElements){

            if(name == "method3"){
                name = element.getMethodName();
                //System.out.println(name);
                return name;
            }
            name = element.getMethodName();
        }
        return name;
    }

    public static String method4() {
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String name =  "";
        for (StackTraceElement element : stackTraceElements){

            if(name == "method4"){
                name = element.getMethodName();
                //System.out.println(name);
                return name;
            }
            name = element.getMethodName();
        }
        return name;
    }

    public static String method5() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String name =  "";
        for (StackTraceElement element : stackTraceElements){

            if(name == "method5"){
                name = element.getMethodName();
                //System.out.println(name);
                return name;
            }
            name = element.getMethodName();
        }
        return name;
    }
}
