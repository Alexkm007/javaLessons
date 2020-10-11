package com.javarush.task.task25.task2515;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;
    private boolean isAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public  void draw (){};
    public  void move (){};
    public  void die (){
        isAlive = false;
    };

    public boolean isIntersect(BaseObject o){
        // Расстояние между центрами окружностей
        double distance = Math.sqrt((o.x - x) * (o.x - x) + (o.y - y) * (o.y - y));
        if(distance <= (o.radius + radius)){
            return true;
        }
        return false;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        isAlive = true;
    }
}
