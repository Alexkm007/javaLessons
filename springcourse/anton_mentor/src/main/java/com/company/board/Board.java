package com.company.board;

import com.company.shapes.Shape;

public class Board {

    private Shape a,b,c,d;
    private static Board board = null;

    private Board() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public static Board getBoard(){
        if(board==null){
            board = new Board();
        }
       return board;
    }

    public void addShape(Shape shape, Parts part){
        if(shape == null){
            return;
        }
        dellShape(shape);

        switch (part) {
            case A:
                a = shape;
                break;
            case B:
               b = shape;
               break;
            case C:
                c = shape;
                break;
            case D:
                d = shape;
        }

    }

    public void dellShape(Parts part){
        switch (part) {
            case A:
                a = null;
                break;
            case B:
                b = null;
                break;
            case C:
                c = null;
                break;
            case D:
                d = null;
        }
    }

    public void dellShape(Shape shape){
        if(shape == null) return;
        if(a == shape) a = null;
        if(b == shape) b = null;
        if(c == shape) c = null;
        if(d == shape) d = null;
    }

    @Override
    public String toString() {
       int i = 0;
       double area = 0;
       StringBuilder sb = new StringBuilder();
        if(a!=null){
            sb.append("На доске есть фигура: " + a.getClass().getSimpleName() + System.lineSeparator());
            i++;
            area+=a.getArea();
        }
        if(b!=null){
            sb.append("На доске есть фигура: " + b.getClass().getSimpleName() + System.lineSeparator());
            i++;
            area+=b.getArea();
        }
        if(c!=null){
            sb.append("На доске есть фигура: " + c.getClass().getSimpleName() + System.lineSeparator());
            i++;
            area+=c.getArea();
        }
        if(d!=null){
            sb.append("На доске есть фигура: " + d.getClass().getSimpleName() + System.lineSeparator());
            i++;
            area+=d.getArea();
        }
        System.out.println();
        sb.append(String.format("Всего фигур: %d, общий периметр: %.2f",i,area));
        return sb.toString();
    }


}
