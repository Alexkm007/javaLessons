package com.example.springcourse;

public class test {
    public static void main(String args[]) {
        int x=1;
        Integer y=2;

        sum(x,y);
        System.out.println(x+" "+y);
    }
    static void sum (int x, Integer y){
        x=x+1;
        y=y+1;
    }
}