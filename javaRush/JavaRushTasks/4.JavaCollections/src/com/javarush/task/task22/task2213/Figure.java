package com.javarush.task.task22.task2213;

public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
    /**
     * Двигаем фигурку влево.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void left() {
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    /**
     * Двигаем фигурку вправо.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void right() {
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    /**
     * Двигаем фигурку вверх.
     * Используется, если фигурка залезла на занятые клетки.
     */
    public void up() {
        y--;
    }

    /**
     * Двигаем фигурку вниз.
     */
    public void down() {
        y++;
    }


    public void rotate(){}

    public void downMaximum(){}

    public boolean isCurrentPositionAvailable(){return true;}

    public void landed(){}
}
