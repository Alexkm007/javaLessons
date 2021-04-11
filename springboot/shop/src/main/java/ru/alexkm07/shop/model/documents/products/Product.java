package ru.alexkm07.shop.model.documents.products;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.reference.Country;
import ru.alexkm07.shop.model.documents.reference.Manufacturer;
import ru.alexkm07.shop.model.documents.reference.Unit;

import javax.persistence.*;
import java.util.Set;

@Data
@Document
@EqualsAndHashCode(of = {"id"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "products_sequence";
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
