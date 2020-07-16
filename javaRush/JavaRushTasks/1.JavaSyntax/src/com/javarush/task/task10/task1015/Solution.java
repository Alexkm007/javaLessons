package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
        {
            //Массив списков типа Стринг равно создать массив списков на 3 элемента
            ArrayList<String>[] listOfList = new ArrayList[3];

            ArrayList<String> list1 = new ArrayList<String>();
            ArrayList<String> list2 = new ArrayList<String>();
            ArrayList<String> list3 = new ArrayList<String>();

            for (int i = 1; i < 10; i++) {
                list1.add("asfadd");
                list2.add("akllkjvzxcv");
                list3.add("alhj;;j;;ok;ojlhuh");
            }
            listOfList[0] = list1;
            listOfList[1] = list2;
            listOfList[2] = list3;
            return listOfList;
        }

        public static void printList (ArrayList < String >[]arrayOfStringList){
            for (ArrayList<String> list : arrayOfStringList)
            {
                for (String s : list) {
                    System.out.println(s);
                }
            }
        }
    }