package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( of = {"id"})
public class ProductDto extends AbstractDto{
    private String name;
    private String SKUNumber;
    private Double price;

}
