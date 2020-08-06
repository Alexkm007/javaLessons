package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;

public class GameObject {
    public double x;
    public double y;
    public int[][] matrix;
    public int width;
    public int height;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
        width = matrix[0].length;
        height = matrix.length;
    }

    public void draw(Game game){

        for(int x = 0;x<matrix[0].length;x++){
            for(int y = 0;y<matrix.length;y++){
                game.setCellValueEx(x + (int)this.x,y + (int)this.y, Color.values()[matrix[y][x]], "");
            }
        }

    }


}
