package homework4.part2;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SortArray {

    private int arrey[];

    public SortArray() {
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
            arrey[j] = (int) (random.nextInt(100000));
        }
    }

    public static void printArrey(int[] arrey) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arrey.length; i++) {
            if (i < arrey.length - 1) {
                sb.append(arrey[i]).append(",");
            } else sb.append(arrey[i]);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static int[] oneThredSort(int[] arrey) {

        for (int step = arrey.length / 2; step > 0; step /= 2) { //шаг перестановки от n/2 до 1
            for (int i = step; i < arrey.length; i++) {            //  итерируем от шага перестоновки до конца массива
                for (int j = i; j >= step && arrey[j] < arrey[j - step]; j -= step) { //берем пары для перестановки
                    int temp = arrey[j];
                    arrey[j] = arrey[j - step];
                    arrey[j - step] = temp;
                }
            }

        }

        return arrey;
    }

    private static int[] merge(int[] leftPart, int[] rightPart) {
        int cursorLeft = 0;
        int cursorRight = 0;
        int counter = 0;
        int[] merged = new int[leftPart.length + rightPart.length];
        while (cursorLeft < leftPart.length && cursorRight < rightPart.length) {
            if (leftPart[cursorLeft] < rightPart[cursorRight]) {
                merged[counter] = leftPart[cursorLeft];
                cursorLeft += 1;
            } else {
                merged[counter] = rightPart[cursorRight];
                cursorRight += 1;
            }
            counter++;
        }
        if (cursorLeft < leftPart.length) {
            System.arraycopy(leftPart, cursorLeft, merged, counter, merged.length - counter);
        }
        if (cursorRight < rightPart.length) {
            System.arraycopy(rightPart, cursorRight, merged, counter, merged.length - counter);
        }
        return merged;
    }

    public static int[] multiThreadSort(int[] arrey, int countTreads) throws ExecutionException, InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        ExecutorService executorService = Executors.newFixedThreadPool(countTreads);
        List<Future<int[]>> todo = new ArrayList<Future<int[]>>();

        int findex = 0;
        int lindex = 0;
        int step = arrey.length/countTreads+1;
        for (int i = 0; i <= countTreads; i++) {
            if (findex >= arrey.length) break;
            lindex = findex + step;
            if (lindex > arrey.length) {
                lindex = arrey.length;
            }
            int[] arreyToSort = Arrays.copyOfRange(arrey, findex, lindex);

            Callable task = new Callable<int[]>() {
                @Override
                public int[] call() throws Exception {
                    int[] sortedArrey = SortArray.oneThredSort(arreyToSort);
                    return sortedArrey;
                }
            };
            todo.add(executorService.submit(task));
            findex = lindex;
        }

        int[] temp = new int[0];
        int[] rezult;
        for (Future future : todo) {
            rezult = merge(temp,(int[])future.get());
            temp = rezult.clone();
        }
        executorService.shutdown();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);

        System.out.println("Время выполнение сортировки в " + countTreads + " потоков: " + duration.toMillis() + "мс");
        return temp;
    }

}
