package ru.alexkm07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderRow {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private int id;
    @Getter
    @Setter
    private Product product;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private double quantity;
    @Getter
    @Setter
    private double amount;
}
