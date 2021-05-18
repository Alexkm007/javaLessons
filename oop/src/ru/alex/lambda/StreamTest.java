package ru.alex.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> list = generateRandomList(20);
        System.out.println(list);

        System.out.println(list.stream().filter(a->a>5)
                .collect(Collectors.toList()));

        System.out.println(list.stream().map(a->a+1000).collect(Collectors.toList()));
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        list.stream().map(a->a+222).peek(System.out::print).collect(Collectors.toList());

    }

    private static List<Integer> generateRandomList(int i) {

        ArrayList<Integer> list = new ArrayList(i);
        Random random = new Random();

        for(int j = 1; j<i;j++){
            list.add(random.nextInt(i));
        }

        return list;
    }


}
