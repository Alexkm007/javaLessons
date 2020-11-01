package com.company;
//37 строка последняя

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[] strings = new String[]{"aa", "a1", "c22", "f"};

        List<String> list = Stream.of("aa", "a1", "c22", "f")
                .filter(s -> s.length() <= 2)
                .collect(Collectors.toList());
        System.out.println(list);


        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Viktor"));
        artists.add(new Artist("Alexei"));
        artists.add(new Artist("Ira"));
        artists.add(new Artist("Marina"));
        long count =artists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.getName().equals("Ira");
                }).count();
        System.out.println(count);

    }
}
