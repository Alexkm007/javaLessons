package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread thred = new TestThread();
        thred.start();
        //Thread.sleep(200);
        thred.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        @Override
        public void run() {

                try {
                    while (true) {
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }
