package StructuralPatterns.Composite;

public class CompositeApp {
    public static void main(String[] args) {

        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();

        Composite comp1 = new Composite();
        comp1.addComponent(square1);
        comp1.addComponent(triangle1);
        comp1.addComponent(circle1);

        Composite comp2 = new Composite();
        comp2.addComponent(square2);
        comp2.addComponent(comp1);
        comp2.addComponent(triangle2);
        comp2.addComponent(circle2);

        comp2.draw();
    }
}
