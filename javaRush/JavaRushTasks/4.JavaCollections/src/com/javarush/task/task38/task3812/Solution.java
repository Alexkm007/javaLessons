package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
            if(c.isAnnotationPresent(PrepareMyTest.class)){
                PrepareMyTest ps = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
                String[] str =ps.fullyQualifiedNames();
                for(String s:str){
                System.out.println(s);}
                return true;
            }
           return false;
        }


    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest ps = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class<?>[] classes =ps.value();
            for(Class<?> clazz:classes){
                System.out.println(clazz.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
