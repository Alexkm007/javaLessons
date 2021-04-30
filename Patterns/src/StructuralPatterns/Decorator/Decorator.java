package StructuralPatterns.Decorator;

public class Decorator implements PrinterInterface{

    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
        System.out.print("]");
    }
}
