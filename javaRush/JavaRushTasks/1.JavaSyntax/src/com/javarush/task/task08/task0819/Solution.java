package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        for(Cat cat:cats){
            cats.remove(cat);
            break;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> set = new HashSet<>();
        set.add(new Cat());
        set.add(new Cat());
        set.add(new Cat());
        return set;
    }

    public static void printCats(Set<Cat> cats) {
       for(Cat cat:cats){
           System.out.println(cat.toString());
       }
    }

    public static class Cat{
        public Cat() {
        }
    }
}

