package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //Находим медиану
        //Сортируем массив из параметра
        int median;
        Arrays.sort(array);
        //Если массив с четным колличеством элементов
        if (array.length%2==0) median = (array[array.length/2] + array[array.length/2-1])/2;
            //И если с нечетным
        else median = array[array.length/2];

        //Сортируем по условию
        Arrays.sort(array,(x, y)->Integer.compare(Math.abs(median-x), Math.abs(median-y)));
        return array;
    }
}
