package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        if(Planet.SUN.equals(key)){
            thePlanet = Sun.getInstance();
        }
        if(Planet.MOON.equals(key)){
            thePlanet = Moon.getInstance();
        }
        if(Planet.EARTH.equals(key)){
            thePlanet = Earth.getInstance();
        }
        if(!Planet.SUN.equals(key)&!Planet.MOON.equals(key)&!Planet.EARTH.equals(key)){
            thePlanet = null;
        }

    }

}
