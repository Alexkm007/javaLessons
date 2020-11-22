package homework4.part1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class ArreySumm {

    private int[] arrey;

    public ArreySumm() {
    }

    public int[] getArrey() {
        return arrey;
    }

    public void setArrey(int[] arrey) {
        this.arrey = arrey;
    }

    public void initialArrey(int i) {
        arrey = new int[i];
        Random random = new Random();
        for (int j = 0; j < i; j++) {
            arrey[j] = random.nextInt(10000);
        }
    }

    public long summAllArrey() {
        long x = 0;
        for (int j : arrey) {
            x += j;
        }
        return x;
    }

    public long summPartArrey(int i, int j) {
        long x = 0;
        for (; i <= j; i++) {
            x += arrey[i];
        }
        return x;
    }

    public long returnDurationOneThread() throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Сумма массива в однопотоке: " + summAllArrey());
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);

        return duration.toMillis();
    }


    public long returnDurationMultiThread(int countThread) {

        int indexStart = 0;
        int step = arrey.length / countThread;
        int indexEnd = indexStart + step;
        List<Future<Long>> futureList = new ArrayList<>();
        ExecutorService  executor = Executors.newFixedThreadPool(countThread);

        LocalDateTime startTime = LocalDateTime.now();
        for (int i = 1; i <= countThread; i++) {
            int delta = arrey.length - indexEnd;
            int start = indexStart;
            int end   = indexEnd;

            Callable task = new Callable() {
                @Override
                public Object call() throws Exception {
                    return summPartArrey(Integer.valueOf(start), delta < step ? arrey.length - 1 : end);
                }
            };
            futureList.add(executor.submit(task));

            indexStart = indexEnd+1;
            indexEnd +=step;

        }
        long k = 0;
        for(Future<Long> fut : futureList){
            try {
                k+=fut.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Сумма массива в мультипотоке: "+k);
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        return duration.toMillis();

    }


}
