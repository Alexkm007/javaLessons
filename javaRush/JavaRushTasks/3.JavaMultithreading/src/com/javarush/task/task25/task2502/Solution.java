package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();
            if(loadWheelNamesFromDB().length !=4){
                throw new Exception();
            }
            for(String name:loadWheelNamesFromDB()){
                Wheel wheel = Wheel.valueOf(name);
                if(wheel!=null && !wheels.contains(wheel) && loadWheelNamesFromDB().length==4){
                    wheels.add(wheel);
                }else {
                    throw new Exception();
                }

           }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

    }
}
