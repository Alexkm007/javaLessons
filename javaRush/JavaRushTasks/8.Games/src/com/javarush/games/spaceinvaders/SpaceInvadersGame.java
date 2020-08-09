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
    private List<Bullet> playerBullets;
    private static final int PLAYER_BULLETS_MAX = 1;


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
        playerShip.move();
        enemyFleet.move();
        for(Bullet bullet:enemyBullets){
            bullet.move();
        }
        for(Bullet bullet:playerBullets){
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
       i = 0;
        while (i < playerBullets.size()){
            Bullet bullet = playerBullets.get(i);
            if((bullet.y + bullet.height) < 0 || !bullet.isAlive){
                playerBullets.remove(i);
                continue;
            }
            i++;
        }
    }

    private void check(){
        playerShip.verifyHit(enemyBullets);
        enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
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
        playerBullets = new ArrayList<Bullet>();
        drawScene();
        super.setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        for(Bullet bullet:enemyBullets){
            bullet.draw(this);
        }
        for(Bullet bullet:playerBullets){
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

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if(x<0||x>=WIDTH||y<0||y>=HEIGHT){
            return;
        }
        super.setCellValueEx(x, y, cellColor, value);
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
    public void onKeyReleased(Key key) {
        if(key==Key.LEFT && playerShip.getDirection() == Direction.LEFT){
            playerShip.setDirection(Direction.UP);
        }

         if( key == Key.RIGHT  && playerShip.getDirection() == Direction.RIGHT){
             playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void onKeyPress(Key key) {
       if(key == Key.SPACE && isGameStopped) {
           createGame();
       }
       if(key == Key.LEFT){
           playerShip.setDirection(Direction.LEFT);
       } else if (key == Key.RIGHT) {
           playerShip.setDirection(Direction.RIGHT);
       }
        if (key == Key.SPACE && !isGameStopped){
          Bullet bullet = playerShip.fire();
          if(bullet != null && playerBullets.size()< PLAYER_BULLETS_MAX){
              playerBullets.add(bullet);
          }

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
