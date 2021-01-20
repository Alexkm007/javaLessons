package ru.alexkm07.model;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Engine {
    private int id;
    private String name;
    private int power;
    private String carMark;
    private Set<Car> cars;
}
