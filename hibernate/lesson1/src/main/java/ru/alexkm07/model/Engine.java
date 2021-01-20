package ru.alexkm07.model;

import lombok.*;

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Engine {
    private int id;
    private String model;
    private int power;
}
