package com.company.shapes;

public class Circle extends Shape{
    private Point a; //центр окружности
    private Point b; //точка края окружности

    public Circle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimetr() {
        double r = a.gedDistance(b);
        return r*2*Math.PI;
    }

    @Override
    public double getArea() {
        double r = a.gedDistance(b);
        return Math.PI*r*r;
    }
}
