package ru.alexkm07.spdata.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {
    public Product(String name) {
        this.name = name;
    }
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private int id;
    @Getter
    @Setter
    private String name;
}
