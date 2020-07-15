package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        even = 0;
        odd  = 0;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String sint = reader.readLine();
        int length = sint.length();
        int i = 0;
        int k = 0;
        while (i<=length-1){
          k = Integer.parseInt(sint.substring(i,i+1));
          if (k%2==0){
              even++;
          }  else odd++;
          i++;
        }
        System.out.println("Even: " +even + " Odd: " +odd);


    }
}
