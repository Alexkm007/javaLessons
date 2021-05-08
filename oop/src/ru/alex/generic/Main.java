package ru.alex.generic;

import javax.print.attribute.IntegerSyntax;

public class Main {

    public static void main(String[] args) {

        A<?> a = new A(Integer.valueOf(5));
        A<?> a1 = new A(Integer.valueOf(10));

        A<?> a2 = new A(new String("dd"));

        A<Integer>[] d = new A[10];
//        d[0] = a;
//        d[1] = a1;
//        d[3] = a2;

        B b = new B();
        b.print("hi");
    }
}
