package StructuralPatterns.Flyweight;

//Flyweight
public class Point implements Shape{
    @Override
    public void draw(int x, int y) {
        System.out.println("Рисуем точку: " + x + " " +y);
    }
}
