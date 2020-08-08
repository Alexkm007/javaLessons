package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public final static int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createStars(){
        stars = new ArrayList<>();
        for(int i = 0;i<=7;i++){
            Star star = new Star(getRandomNumber(0,WIDTH),getRandomNumber(0,WIDTH));
            stars.add(star);
        }
    }

    private void moveSpaceObjects(){
        enemyFleet.move();
        for(Bullet bullet:enemyBullets){
            bullet.move();
        }
    }

    private void removeDeadBullets(){
        int i = 0;
        while (i < enemyBullets.size()){
            Bullet bullet = enemyBullets.get(i);
            if(bullet.y >= HEIGHT-1 | !bullet.isAlive){
                enemyBullets.remove(i);
                continue;
            }
            i++;
        }
    }

    private void check(){
        playerShip.verifyHit(enemyBullets);
        removeDeadBullets();
        if(!playerShip.isAlive){
            stopGameWithDelay();
        };
    }

    private void createGame() {
        createStars();
        enemyBullets = new ArrayList<Bullet>();
        enemyFleet = new EnemyFleet();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        drawScene();
        super.setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        for(Bullet bullet:enemyBullets){
            bullet.draw(this);
        }
        enemyFleet.draw(this);
        playerShip.draw(this);
    }

    private void stopGame(boolean isWin){
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.AQUA, "WIN WIN WIN", Color.GREEN, 50);
        } else {
            showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 50);
        }
    }

    private void stopGameWithDelay(){
        animationsCount++;
        if(animationsCount>=10) {
            stopGame(playerShip.isAlive);
        }
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for(Star star:stars){
            star.draw(this);
        }
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if(bullet != null){
            enemyBullets.add(bullet);
        };
        drawScene();
    }


}
