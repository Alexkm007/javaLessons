package com.company;

import java.util.stream.Stream;

//страница 44 след шаг
public class Reduce {
    public static void main(String[] args) {
        int sum =  Stream.of(1,2,3).reduce(10,(acc,element)->acc+element);
        System.out.println(sum);;
    }
}
