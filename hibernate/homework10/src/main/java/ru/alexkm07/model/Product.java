package ru.alexkm07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private int id;
    @Getter
    @Setter
    private String name;
}
