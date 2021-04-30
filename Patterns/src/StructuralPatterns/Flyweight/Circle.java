package StructuralPatterns.Flyweight;

//Flyweight
public class Circle implements Shape{

    private int r = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("Рисуем круг: " + x + " " +y + " с радиусом " + r);
    }
}
