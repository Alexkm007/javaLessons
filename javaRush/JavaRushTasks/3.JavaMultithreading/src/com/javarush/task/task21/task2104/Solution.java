package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if(n==null){
            return false;
        }
        if(!(n instanceof Solution)){
            return false;
        }
        if(n == this){
            return true;
        }

        if(first == null && ((Solution) n).first == null && last == null && ((Solution) n).last==null){
            return true;
        }
        if(first == null && ((Solution) n).first == null){
            return ((Solution) n).last.equals(last);
        }
        if(last == null && ((Solution) n).last==null){
            return ((Solution) n).first.equals(first);
        }
        if(first != null && ((Solution) n).first != null && last != null && ((Solution) n).last!=null){
            return ((Solution) n).first.equals(first) && ((Solution) n).last.equals(last);
        }
        return false;
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
