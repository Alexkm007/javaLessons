package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.products.Product;
import ru.alexkm07.shop.model.reference.Unit;


@Data
@EqualsAndHashCode(of = {"id"})
public class ItemDto extends AbstractDto {
    private Product product;
    private Unit unit;
    private Double quantity;
}
