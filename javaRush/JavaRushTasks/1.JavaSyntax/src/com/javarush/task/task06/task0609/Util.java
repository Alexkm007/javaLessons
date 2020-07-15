package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double xd1,xd2,yd1,yd2, dist;
        xd1 = x1;
        xd2 = x2;
        yd1 = y1;
        yd2 = y2;
        dist = Math.sqrt(Math.pow((xd1-xd2),2) +Math.pow((yd1-yd2),2));
        return dist;
    }

    public static void main(String[] args) {

    }
}
