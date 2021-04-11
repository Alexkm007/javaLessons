package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( of = {"id"})
public class UnitDto extends AbstractDto{
    private Long Id;
    private String name;
    private Long ratio;
}
