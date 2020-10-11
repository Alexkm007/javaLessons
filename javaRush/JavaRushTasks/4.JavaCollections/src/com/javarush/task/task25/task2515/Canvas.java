package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];

    }

    public void setPoint(double x, double y, char c){
        int iX = (int) Math.round(x);
        int iY = (int) Math.round(y);
        if(iX < 0 || iX >=matrix[0].length || iY<0 || iY >= matrix.length){
            return;
        }
        matrix[iY][iX] = c;

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){

        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(matrix[i][j] != 0){
                    setPoint(x+j, y+i, c);
                }
            }
        }


    }
}
