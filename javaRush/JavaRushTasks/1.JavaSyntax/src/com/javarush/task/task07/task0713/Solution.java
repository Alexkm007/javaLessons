package com.javarush.task.task07.task0713;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        for (int i=0;i<=19;i++){
            x = Integer.parseInt(reader.readLine());
            list1.add(x);
            if (x%3==0){
                list2.add(x);
            }
            if (x%2==0){
                list3.add(x);
            }
            if (x%3!=0 & x%2!=0){
                list4.add(x);
            }
        }
        printList(list1);
        printList(list2);
        printList(list3);
        printList(list4);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0;i<=list.size()-1;i++){
            System.out.println(list.get(i));
        }
    }
}
