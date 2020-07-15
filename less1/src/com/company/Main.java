package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Word!!!");
        initial();
        float result = calculate(10f,20f,40f, 15f);
        System.out.println("Резльутат: " + result);
        posOrNeg(-12);
        posOrNeg(20);
        printName("Чернобород");
        checkYaer(2020);
        checkYaer(2021);
        checkYaer(2022);
        checkYaer(2016);
        checkYaer(2000);
        checkYaer(1900);
        checkYaer(1600);
    }

    public static void initial(){
       //integer
        byte myByte = 3;
        short myshort = 4;
        int myInt = 5;
        long myLong = 2L;

        //float
        float fl = 1.01f;
        double db = 1.01d;

        //strings
        char mychar = 'Y';
        String myString = "Hello Word";

        //boolean
        boolean myBoolean = true;

    }

    public static float calculate(float a, float b, float c, float d){

        return a*(b+(c/d));

    }

    public static boolean myIf(int a, int b){
        int c = a+b;

        if (c>=10 && c <=20) {
            return true;
        }else{
            return false;
            }


    }

    public static void posOrNeg(int x){
        if (x>=0){
            System.out.println("Число: " +x+ " Положительное");
        }else System.out.println("Число: " +x+ " Отрицательное");
    }

    public static void printName(String name){
        System.out.println("Привет, " + name);
    }

    public static void checkYaer(int year){

        int x = (2020 - year)%4;
        if (x!=0){
            System.out.println(year + " Не высокостный");
            return;
        }else if(year%100!=0){
            System.out.println(year +" Высокостный");
            return;
        }
       if ((2000 - year)%400!=0){
            System.out.println(year +" Не высокостный");
            return;
        }
        System.out.println(year +" Высокостный");
    }

}
