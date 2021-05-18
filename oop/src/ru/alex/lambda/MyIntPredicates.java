package ru.alex.lambda;

public class MyIntPredicates {

    static boolean isPrime(int n){

        if( n < 2) return false;

        for ( int i = 2; i <= n/i; i++){
            if((n%i)==0){
                return false;
            }
        }
        return true;
    }

    static boolean isEven(int n){
        return (n%2)==0;
    }

    static boolean isPositive(int n){
       return n>0;
    }

}
