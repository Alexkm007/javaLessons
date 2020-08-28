package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        synchronized (o2) {
            synchronized (o1) {
                thread1.start();
                Thread.sleep(10);
            } //отпускаем монитор o1
            Thread.sleep(10);
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o1) {
                        //System.out.println("o1 не захвачен потоком thread1");
                    }
                }
            });
            thread2.start();
            Thread.sleep(10); //ждем чтобы thread2 стартанул и попытался захватить o1
            return Thread.State.BLOCKED.equals(thread2.getState());
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
