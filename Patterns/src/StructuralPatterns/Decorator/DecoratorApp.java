package StructuralPatterns.Decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new Printer("Привет");
        printer.print();

        PrinterInterface decorator = new Decorator(printer);
        decorator.print();


    }
}
