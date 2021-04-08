package ru.alexkm07.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prd_seq")
    @SequenceGenerator(name = "prd_seq", sequenceName = "prd_seq")
    private Long id;
    private String name;
    private String SKUNumber;
    private Double price;
    @OneToOne()
    private Unit unit;
}
