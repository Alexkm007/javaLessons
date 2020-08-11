package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;


    public static void main(String[] args) throws InterruptedException {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("Маня",3,0));
        list.add(new Horse("Ветер",3,0));
        list.add(new Horse("Хромой",3,0));
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for(int i = 1;i<=100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void print(){
        for(Horse horse:horses){
            horse.print();
        }
        for(int i = 0;i<10;i++){
            System.out.println("");
        }

    }
    public void move(){
        for(Horse horse:horses){
            horse.move();
        }
    }

    public Horse getWinner(){
        double maxDist = Double.MIN_VALUE;
        Horse winner  = null;
        for(Horse horse:horses){
           if(maxDist<horse.distance){
               maxDist = horse.distance;
               winner = horse;
           }
        }
        return winner;
    }
    public void printWinner(){
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }

}
