package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;


    public EnemyFleet() {
        createShips();
    }

    private double getSpeed() {
        return (3.0 / ships.size() < 2.0) ? 3.0 / ships.size() : 2.0;
    }

    public void move() {

        if (ships.size() == 0) {
            return;
        }
        Direction oldDirection = direction;
        if (direction == Direction.LEFT & getLeftBorder() < 0) {
            direction = Direction.RIGHT;
        }
        if (direction == Direction.RIGHT & getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
        }
        double speed = getSpeed();
        if (oldDirection != direction) {

            for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN, speed);
            }
        } else {
            for (EnemyShip ship : ships) {
                ship.move(direction, speed);
            }
        }

    }

    public void draw(Game game) {
        for (Ship ship : ships) {
            ship.draw(game);
        }
    }

    private double getLeftBorder() {
        double min = Double.MAX_VALUE;
        for (EnemyShip ship : ships) {
            if (min > ship.x) {
                min = ship.x;
            }
        }
        return min;
    }

    private double getRightBorder() {
        double max = Double.MIN_VALUE;
        for (EnemyShip ship : ships) {
            if (ship.x > max) {
                max = ship.x;
            }
        }
        return max + ShapeMatrix.ENEMY.length;
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2-1,5));
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) {
            return null;
        }
        int x = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (x > 0) {
            return null;
        } else {
            int indexShip = game.getRandomNumber(ships.size());
            return ships.get(indexShip).fire();
        }
    }

    public void deleteHiddenShips() {
        int i = 0;
        while (i < ships.size()) {
            Ship ship = ships.get(i);
            if (!ship.isVisible()) {
                ships.remove(i);
                continue;
            }
            i++;
        }
    }

    public double getBottomBorder(){
        double max = Double.MIN_VALUE;
        for(EnemyShip ship:ships){
           if(ship.y+ship.height>max){
               max = ship.y+ship.height;
           }
       }
        return max;
    }

    public int getShipsCount(){
        return ships.size();
    }

    public int verifyHit(List<Bullet> bullets) {
        if(bullets.size() == 0 ){
            return 0;
        }
        int score = 0;
        for (EnemyShip enemyShip : ships) {
            for (Bullet bullet : bullets) {
                if (enemyShip.isAlive && bullet.isAlive && enemyShip.isCollision(bullet)) {
                    enemyShip.kill();
                    bullet.kill();
                    score = score+enemyShip.score;
                }
            }
        }

        return score;

    }

}
