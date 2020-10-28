package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(isOneEditAway("ava", "avA")); //true

    }

    public static boolean isOneEditAway(String first, String second) {
        if(first.equals(second)) return true;
        if(Math.abs(first.length()-second.length())>1) return false;
        int lenght = 0;
        if(first.length()==second.length()){
            lenght =  calculateLenght(first,second,lenght);
        }else if(first.length()>second.length()){
            lenght++;
            lenght =  calculateLenght(second,first,lenght);
        }else {
            lenght++;
            lenght =  calculateLenght(first,second,lenght);
        }
        if(lenght > 1) return false;
        return true;
    }


    private static int calculateLenght(String first, String second,int lenght){
        int index = 0;
        for(int i = 0; i<first.length();i++){
            if(!first.substring(i,i+1).equals(second.substring(i,i+1))
                    && first.length() != second.length()
                    && (i<second.length()-1)
                    && !first.substring(i,i+1).equals(second.substring(i+1,i+2))){
                lenght++;
            }else if(!first.substring(i,i+1).equals(second.substring(i,i+1))
                    && first.length() == second.length()){
                lenght++;
            }
        }
        return lenght;
    }
}
