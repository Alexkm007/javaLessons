package com.javarush.task.task14.task1417;

public class Hrivna extends Money {
    public Hrivna(double amount) {
        super(amount);
    }

//    public double getAmount() {
//        return super.getAmount();
//    }

    public String getCurrencyName() {
        return "UAH";
    }
}
