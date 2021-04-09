package ru.alexkm07.shop.model.products;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.reference.Country;
import ru.alexkm07.shop.model.reference.Manufacturer;
import ru.alexkm07.shop.model.reference.Unit;

import javax.persistence.*;
import java.util.Set;

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
    @OneToOne()
    private Manufacturer manufacturer;
    @OneToMany()
    private Set<Category> categories;
    @OneToOne()
    private Country CountryOfManufacture;
    @OneToOne
    private Folder folder;
    private String pictureLink;
}
