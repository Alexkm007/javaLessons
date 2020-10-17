package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator{
    private Shape decoratedShape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }


    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        super.draw();
    }

    private void setBorderColor(Shape shape){
        System.out.println("Setting the border color for "+ shape.getClass().getSimpleName()+" to red.");
    }
}
