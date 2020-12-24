package com.company.shapes;

public class Rectangle extends Shape{

    private Point a,b,c,d;// точки прямоугльника от левого нижнего по часовой стрелке

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getPerimetr() {
        double length = a.gedDistance(d);
        double width  = a.gedDistance(b);
        return (length+width)*2;
    }
    @Override
    public double getArea() {
        double length = a.gedDistance(d);
        double width  = a.gedDistance(b);
        return width*length;
    }


}
