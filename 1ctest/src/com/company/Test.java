package com.company;

public class Test {
    public Test() {
    }

    private static native void log(String info);

    public static String mainInt(int key){
        log(""+key + " привет из JAva");
        return ""+key + " привет из JAva";
    }

    public static void main(String[] args) {
	// write your code here
    }
}
