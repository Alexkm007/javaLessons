package ru.alexkm07.shop.model.products;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
public class Category {
    @Id
    private Long id;
    private String Name;
}
