package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class FlatMap {
    public static void main(String[] args) {
        //ПРимер с объектным листом
        List<Human> humans = asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));
        List<String> petNames = humans.stream()
                .flatMap(human->human.getPets().stream())
                .collect(toList());

        System.out.println(petNames);
        // пример с созданием на лету списков
        List<Integer> together = Stream.of (asList (1, 2), asList (3, 4))
                .flatMap(numbers -> numbers.stream()).collect(toList());
        System.out.println(together);

    }


    static class Human {
        private final String name;
        private final List<String> pets;

        Human(String name, List<String> pets) {
            this.name = name;
            this.pets = pets;
        }

        public List<String> getPets() {
            return pets;
        }

        //constructors, getters
    }

}
