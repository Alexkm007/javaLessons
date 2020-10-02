package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    public static void writeMessage(String mesage){
        System.out.println(mesage);
    }

    public static String readString() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return rd.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString() + " выберите блюдо(а), выход из выбора exit");
        while (true){
          String dish = readString();
          if(dish.equalsIgnoreCase("exit")){
              break;
          }
          try {
              dishes.add(Dish.valueOf(dish));
          }catch (Exception e){
              writeMessage("такого блюда нет");
          }
        }
        return dishes;
    }

}
