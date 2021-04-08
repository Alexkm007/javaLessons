package ru.alexkm07.shop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rb_seq")
    @SequenceGenerator(name = "rb_seq", sequenceName = "rb_seq")
    private Long id;
    @OneToOne
    private Product product;
    @OneToOne
    private Unit unit;
    private Double quantity;

}
