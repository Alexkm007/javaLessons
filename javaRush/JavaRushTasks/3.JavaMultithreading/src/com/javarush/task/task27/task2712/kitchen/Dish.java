package com.javarush.task.task27.task2712.kitchen;

import java.beans.PropertyEditorSupport;
import java.rmi.Remote;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int i) {
        duration  = i;
    }

    public int getDuration() {
        return duration;
    }


    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        for (Dish c : Dish.values()) {
            sb.append(c + ",");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }
}
