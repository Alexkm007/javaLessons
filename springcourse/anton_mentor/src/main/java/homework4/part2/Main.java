package homework4.part2;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException  {
        SortArray sortArray = new SortArray();
        sortArray.initialArrey(1000000);
        int[] rowArrey = sortArray.getArrey().clone();
        LocalDateTime start = LocalDateTime.now();
        int[] sortedArrey =  SortArray.oneThredSort(rowArrey.clone());
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Время выполнение сортировки в один поток: " + duration.toMillis()+ "мс");


        int[] sortetMulti =  SortArray.multiThreadSort(rowArrey.clone(),4);
        if(Arrays.equals(sortedArrey,sortetMulti)){
            System.out.println("Массивы совпадают");
        }else{
            System.out.println("Массивы не совпадают");
        }
//        SortArray.printArrey(rowArrey);
//        SortArray.printArrey(sortedArrey);
//        SortArray.printArrey(sortetMulti);
    }
}
