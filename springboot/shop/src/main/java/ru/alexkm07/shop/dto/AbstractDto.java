package ru.alexkm07.shop.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractDto implements Serializable {
    private Long id;
}
