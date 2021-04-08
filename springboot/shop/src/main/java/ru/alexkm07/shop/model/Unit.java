package ru.alexkm07.shop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
    @SequenceGenerator(name = "unit_seq", sequenceName = "unit_seq")
    private Long Id;
    private String name;
    private Long ratio;
}
