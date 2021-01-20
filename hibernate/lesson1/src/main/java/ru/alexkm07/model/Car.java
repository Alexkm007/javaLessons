package ru.alexkm07.model;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String mark;
    private String model;
    private Engine engine;
}
