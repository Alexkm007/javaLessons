package ru.alexkm07.shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bx_seq")
    @SequenceGenerator(name = "bx_seq", sequenceName = "bx_seq")
    private Long id;
    private LocalDateTime creationDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items;
    @ManyToOne
    private User user;
    private Double amount;
}
