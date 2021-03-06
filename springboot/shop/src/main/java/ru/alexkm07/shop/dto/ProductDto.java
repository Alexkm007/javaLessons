package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.documents.products.Category;
import ru.alexkm07.shop.model.documents.products.Folder;
import ru.alexkm07.shop.model.documents.reference.Country;
import ru.alexkm07.shop.model.documents.reference.Manufacturer;
import ru.alexkm07.shop.model.documents.reference.Unit;

import java.util.Set;

@Data
@EqualsAndHashCode( of = {"id"})
public class ProductDto extends AbstractDto{
    private Long id;
    private String name;
    private String SKUNumber;
    private Double price;
    private Unit unit;
    private Manufacturer manufacturer;
    private Set<Category> categories;
    private Country CountryOfManufacture;
    private Folder folder;
    private String pictureLink;
}
