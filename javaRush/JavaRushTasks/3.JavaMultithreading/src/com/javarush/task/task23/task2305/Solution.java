package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] sol = new Solution[2];
        sol[0] = new Solution();
        sol[1] = new Solution();
        sol[0].innerClasses[0] = sol[0].new InnerClass();
        sol[0].innerClasses[1] = sol[0].new InnerClass();

        sol[1].innerClasses[0] = sol[1].new InnerClass();
        sol[1].innerClasses[1] = sol[1].new InnerClass();

        return sol;
    }

    public static void main(String[] args) {

    }
}
