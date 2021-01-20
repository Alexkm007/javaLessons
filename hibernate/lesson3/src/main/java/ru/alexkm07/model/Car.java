package ru.alexkm07.model;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@EqualsAndHashCode(exclude = "engines")
public class Car {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String mark;

    @Getter
    @Setter
    private Integer cost;

    @Getter
    @Setter
    private Set<Engine> engines;
}
