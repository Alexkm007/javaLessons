package StructuralPatterns.Flyweight;

//Flyweight
public class Square implements Shape{

    private int a = 10;

    @Override
    public void draw(int x, int y) {
        System.out.println("Рисуем квадрат: " + x + " " +y +" рисуем квадрат со стороной " + a);
    }
}
