package StructuralPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape{

    private List<Shape> shapes = new ArrayList<>();

    public void addComponent(Shape component){
        shapes.add(component);
    }

    public void deleteComponent(Shape component){
        shapes.remove(component);
    }

    @Override
    public void draw() {
        for(Shape shape:shapes){
            shape.draw();
        }
    }

}
