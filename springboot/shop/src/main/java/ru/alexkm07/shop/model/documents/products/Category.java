package ru.alexkm07.shop.model.documents.products;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
@EqualsAndHashCode(of = {"id"})
public class Category {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "categories_sequence";
    private String Name;
}
