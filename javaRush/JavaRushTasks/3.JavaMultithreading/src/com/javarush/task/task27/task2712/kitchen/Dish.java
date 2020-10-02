package com.javarush.task.task27.task2712.kitchen;

import java.beans.PropertyEditorSupport;
import java.rmi.Remote;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        for (Dish c : Dish.values()) {
            sb.append(c + ",");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }
}
