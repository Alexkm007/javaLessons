package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Human chl1 = new Human();
        chl1.age = 2;
        chl1.name = "Ребенок1";
        chl1.sex = true;
        chl1.children =  new ArrayList<Human>();
        Human chl2 = new Human();
        chl2.age = 2;
        chl2.name = "Ребенок2";
        chl2.sex = true;
        chl2.children =  new ArrayList<Human>();
        Human chl3 = new Human();
        chl3.age = 2;
        chl3.name = "Ребенок3";
        chl3.sex = true;
        chl3.children =  new ArrayList<Human>();
        Human fh = new Human();
        fh.age = 21;
        fh.name = "Отец";
        fh.sex = true;
        fh.children = new ArrayList<Human>();
        fh.children.add(chl1);
        fh.children.add(chl2);
        fh.children.add(chl3);

        Human mh = new Human();
        mh.age = 21;
        mh.name = "Мать";
        mh.sex = false;
        mh.children = new ArrayList<Human>();
        mh.children.add(chl1);
        mh.children.add(chl2);
        mh.children.add(chl3);

        Human gfh1 = new Human();
        gfh1.age = 30;
        gfh1.name = "Дед1";
        gfh1.sex = true;
        gfh1.children = new ArrayList<Human>();
        gfh1.children.add(fh);

        Human gfh2 = new Human();
        gfh2.age = 30;
        gfh2.name = "Дед2";
        gfh2.sex = true;
        gfh2.children = new ArrayList<Human>();
        gfh2.children.add(mh);

        Human gmh1 = new Human();
        gmh1.age = 29;
        gmh1.name = "бабка1";
        gmh1.sex = false;
        gmh1.children = new ArrayList<Human>();
        gmh1.children.add(fh);

        Human gmh2 = new Human();
        gmh2.age = 85;
        gmh2.name = "бабка2";
        gmh2.sex = false;
        gmh2.children = new ArrayList<Human>();
        gmh2.children.add(mh);

        System.out.println(gfh1);
        System.out.println(gfh2);
        System.out.println(gmh1);
        System.out.println(gmh2);
        System.out.println(fh);
        System.out.println(mh);
        System.out.println(chl1);
        System.out.println(chl2);
        System.out.println(chl3);
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
