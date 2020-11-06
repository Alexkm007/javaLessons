package com.company;

import com.company.board.Board;
import com.company.board.Parts;
import com.company.shapes.Circle;
import com.company.shapes.Point;
import com.company.shapes.Rectangle;
import com.company.shapes.Square;

import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(new Point(1, 10), new Point(2, 15));
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(1, 10),
                new Point(10, 10), new Point(10, 1));
        Rectangle rectangle2 = new Rectangle(new Point(1, 1), new Point(1, 10),
                new Point(10, 10), new Point(10, 1));
        Square square = new Square(new Point(1,1),new Point(1,5),
                new Point(5,5), new Point(5,1));

        Board board = Board.getBoard();
        board.addShape(circle, Parts.A);
        board.addShape(rectangle,Parts.B);
        board.addShape(rectangle2,Parts.C);
        board.addShape(square,Parts.D);
        board.dellShape(Parts.B);
        board.dellShape(circle);
        System.out.println(board);
    }
}
