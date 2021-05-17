package ru.alex.collection;

import java.util.*;

public class TestSet {


    public static void main(String[] args) {

        Set a  = new LinkedHashSet();
        a.add(null);
        System.out.println(a.contains(null));


        //NavigableSet b = new TreeSet();
        //b.add(null);

        Map b = new TreeMap();
        b.put(null,"null");

    }






}
