package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        readFile(name,allLines);
        name = rd.readLine();
        readFile(name,forRemoveLines);
        Solution sol = new Solution();
        sol.joinData();
    }

    public static void readFile(String name, List<String> list) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(name));
        while (fr.ready()){
            list.add(fr.readLine());
        }
    }

    public void joinData() throws CorruptedDataException {
        for(String s:forRemoveLines){
            int i = 0;
            boolean cont = false;
            while (i<allLines.size()-1){
                String str = allLines.get(i);
                if(str.equals(s)){
                    allLines.remove(i);
                    cont = true;
                }else {
                    i++;
                }
            }
            if(!cont){
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
