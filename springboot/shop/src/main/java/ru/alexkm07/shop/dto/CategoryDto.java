package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@EqualsAndHashCode(of = {"id"})
public class CategoryDto extends AbstractDto{

    private Long id;
    private String Name;
}
