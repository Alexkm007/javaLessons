package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();
        zerg1.name = "zerg1";
        zerg2.name = "zerg2";
        zerg3.name = "zerg3";
        zerg4.name = "zerg4";
        zerg5.name = "zerg5";

        Protoss prot1 = new Protoss();
        Protoss prot2 = new Protoss();
        Protoss prot3 = new Protoss();
        prot1.name = "prot1";
        prot2.name = "prot2";
        prot3.name = "prot3";

        Terran ter1 = new Terran();
        Terran ter2 = new Terran();
        Terran ter3 = new Terran();
        Terran ter4 = new Terran();
        ter1.name = "ter1";
        ter2.name = "ter2";
        ter3.name = "ter3";
        ter4.name = "ter4";


    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
