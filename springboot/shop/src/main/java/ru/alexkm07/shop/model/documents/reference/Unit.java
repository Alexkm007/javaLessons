package ru.alexkm07.shop.model.documents.reference;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
@Document
@Data
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Transient
    public static final String SEQUENCE_NAME = "unit_sequence";
    private String name;
    private Long ratio;
}
