package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Создаем стрим из масив строк, фильтруем и возвращаем список

public class BeginningWithNumbers {
    public static void main(String[] args) {
        List<String> beginningWithNumbers = Stream.of("a","1abc","abc1")
                .filter(value->Character.isDigit(value.charAt(0)))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(beginningWithNumbers);
    }

}
