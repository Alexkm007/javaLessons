package com.company.shapes;

public class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double gedDistance(Point point){
        return Math.sqrt((x-point.x)*(x-point.x) +(y-point.y)*(y-point.y));
    }
}
