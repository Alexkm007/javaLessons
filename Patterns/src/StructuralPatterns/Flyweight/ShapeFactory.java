package StructuralPatterns.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String,Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName){
        Shape shape = shapes.get(shapeName);
        if(shape==null){
            switch (shapeName){

                case "круг":
                    shape = new Circle();
                    break;
                case "квадрат":
                    shape = new Square();
                    break;
                case "точка":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName,shape);
        }
        return shape;
    }
}
