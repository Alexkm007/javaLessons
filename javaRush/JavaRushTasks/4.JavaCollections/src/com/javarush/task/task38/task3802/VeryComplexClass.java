package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        VeryComplexClass ss = (VeryComplexClass)this.clone();
    }

    public static void main(String[] args) throws Exception {
    }
}
