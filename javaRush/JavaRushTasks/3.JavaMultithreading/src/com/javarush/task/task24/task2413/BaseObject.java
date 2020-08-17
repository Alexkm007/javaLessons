package com.javarush.task.task24.task2413;

import java.io.Serializable;

public abstract class BaseObject {
    protected double x,y,radius;

    public abstract void move();

    public abstract void draw(Canvas canvas);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void checkBorders(double minx, double maxx, double miny, double maxy)
    {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    public boolean isIntersec(BaseObject o){
        double dist = Math.sqrt((x-o.x)*(x-o.x) + (y-o.y)*(y-o.y));
        if(dist<=(radius<o.radius?o.radius:radius)){
            return true;
        }
        return false;
    }
}
