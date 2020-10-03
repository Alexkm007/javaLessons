package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(0);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        Cook cook = new Cook("Vasia");
        tablet.addObserver(cook);
    }
}
