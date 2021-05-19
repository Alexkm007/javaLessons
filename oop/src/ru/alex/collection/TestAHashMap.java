package ru.alex.collection;

import java.util.HashMap;
import java.util.Map;

public class TestAHashMap {

    public static void main(String[] args) {

        A a1 = new A("test1",30);
        A a2 = new A("test2",50);

        Map<A,String> map = new HashMap<>();
        map.put(a1,"test1");
        map.put(a2,"test2");

        a1.setAge(90);

        System.out.println(map.get(a1));


    }

}
