package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for(Thread thread:threads){
           switch (thread.getState()){
               case TERMINATED:
                   System.out.println(thread.getPriority());
                   break;
               case NEW:
                   thread.start();
                   break;
               case RUNNABLE:
                   thread.isInterrupted();
                   break;
               case WAITING:
                   thread.interrupt();
                   break;
               case TIMED_WAITING:
                   thread.interrupt();
                   break;
               case BLOCKED:
                   thread.interrupt();
                   break;
           }
        }
    }

    public static void main(String[] args) {
    }
}
