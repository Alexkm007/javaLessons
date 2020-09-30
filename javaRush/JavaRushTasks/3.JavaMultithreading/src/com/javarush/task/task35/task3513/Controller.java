package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    // конструктор, устанавливает модель и вид для контроллера
    public Controller(Model model) {
        this.model = model;
       // this.view = new View(this);
    }

    // геттер счета
    public int getScore() {
        return model.score;
    }

    //геттер для поля
    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

}
