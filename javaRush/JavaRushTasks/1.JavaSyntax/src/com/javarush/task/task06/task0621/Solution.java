package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String GFatherName = reader.readLine();
        Cat catGFather = new Cat(GFatherName);

        String gmotherName = reader.readLine();
        Cat catGMother = new Cat(gmotherName);

        String FatherName = reader.readLine();
        Cat catFather = new Cat(FatherName,null,catGFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,catGMother,null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName,catMother,catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName,catMother,catFather);

        System.out.println(catGFather);
        System.out.println(catGMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mather;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mather, Cat father) {
            this.name = name;
            this.mather = mather;
            this.father  = father;
        }

        @Override
        public String toString() {
        if (father != null & mather != null){
            return "The cat's name is "+name+", mother is "+mather.name+", father is "+father.name;
        }
        if (father != null & mather ==null){
            return "The cat's name is "+name+", no mother, father is "+father.name;
        }
        if (father == null & mather !=null){
                return "The cat's name is "+name+", mother is "+mather.name+", no father";
        }
        if (father == null & mather ==null){
                return "The cat's name is "+name+", no mother, no father";
        }

        return "";

        }

    }

}
