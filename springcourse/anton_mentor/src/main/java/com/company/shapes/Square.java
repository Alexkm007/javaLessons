package com.company.shapes;

public class Square extends Shape {
   private Point a,b,c,d;// точки квадрата от левого нижнего по часовой стрелке

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getPerimetr() {
        double length = a.gedDistance(b);
        return length*4;
    }

    @Override
    public double getArea() {
        double length = a.gedDistance(b);
        return length*length;
    }
}
