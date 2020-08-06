package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private final static String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.AQUA);
                setCellValue(x,y,"");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if(gameField[y][x].isMine){
                    continue;
                }
                List<GameObject> list = getNeighbors(gameField[y][x]);
                for (GameObject gm : list) {
                    if (gm.isMine) {
                        gameField[y][x].countMineNeighbors++;
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void openTile(int x, int y){
        GameObject cel = gameField[y][x];
        if(isGameStopped | cel.isOpen | cel.isFlag){
            return;
        }
        if(cel.isMine){
            setCellValueEx(x,y,Color.RED,MINE);
            gameOver();
            return;
        }
        if(cel.isMine){
            setCellValue(x,y, MINE);
        } else if(cel.countMineNeighbors>0){
            setCellNumber(x, y, cel.countMineNeighbors);
        }else{
            setCellValue(x,y, "");
        }
        cel.isOpen = true;
        score +=5;
        setScore(score);
        countClosedTiles--;
        setCellColor(x, y, Color.GREEN);
        if(countClosedTiles==countMinesOnField){
            win();
        }
        if(!cel.isMine & cel.countMineNeighbors == 0){
            List<GameObject> list = getNeighbors(cel);
            for(GameObject go:list){
                if(!go.isMine & cel.countMineNeighbors == 0 & !go.isOpen){
                    openTile(go.x,go.y);
                }
            }
        }

    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.BLUE, "WIN!!!", Color.WHITE, 50);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if(isGameStopped){
            restart();
            return;
        }
        openTile(x,y);
    }

    private void markTile(int x, int y){
        if(isGameStopped){
            return;
        }
        if(gameField[y][x].isOpen | (!gameField[y][x].isFlag & countFlags==0)){
            return;
        }
        if(gameField[y][x].isFlag){
            countFlags++;
            gameField[y][x].isFlag = false;
            setCellValue(x,y,"");
            setCellColor(x,y,Color.AQUA);
        }else if(!gameField[y][x].isFlag & countFlags>0){
            gameField[y][x].isFlag = true;
            setCellValue(x,y,FLAG);
            countFlags--;
            setCellColor(x,y,Color.YELLOW);
        }
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(0);
        createGame();
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.CORAL,"GAME IS OVER",Color.BLACK,20);
    }

    @Override
    public void onKeyPress(Key key) {
        if(key.name() == "ESCAPE" & isGameStopped){
            javafx.application.Platform.exit();
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}