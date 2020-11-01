package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        CurrencyManipulator currencyManipulator = map.get(currencyCode.toLowerCase());
        if(currencyManipulator == null){
            currencyManipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode.toLowerCase(),currencyManipulator);
        }
        return currencyManipulator;
    }
}
