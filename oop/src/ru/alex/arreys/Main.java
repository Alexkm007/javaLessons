package ru.alex.arreys;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//
//        int[] x = new int[3];
//        int[] y = {1, 2, 3};
//
//       int[] z = Arrays.copyOf(y,y.length);
//
//        System.out.println(Arrays.toString(z));
//
//        x = y.clone();
//
//        System.out.println(Arrays.toString(x));

        int [] arrayToSort = new int[10];
        generateDateInArray(arrayToSort);

        System.out.println(Arrays.toString(arrayToSort));
        Arrays.sort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
        invert(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));

    }

    static void generateDateInArray(int[] array){

        Random random = new Random();

        for(int i = 0;i<array.length;i++){
            array[i] = random.nextInt(10000);
        }

    }

        public static void invert(int[] array) {
            for (int i = 0; i < array.length / 2; i++) {
                int tmp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] =  tmp;
            }
    }

}
