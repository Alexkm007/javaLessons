package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    private int left,top,width,height;
    public static void main(String[] args) {
    }
    public void initialize(int left,int top,int width,int height){
        this.height = height;
        this.left = left;
        this.top = top;
        this.width = width;
    }
    public void initialize(int left,int top,int width){
        this.height = height;
        this.left = left;
        this.top = top;
    }
    public void initialize(int left,int top){
        this.height = height;
        this.left = left;
    }
    public void initialize(int left){
        this.height = height;
    }
}
