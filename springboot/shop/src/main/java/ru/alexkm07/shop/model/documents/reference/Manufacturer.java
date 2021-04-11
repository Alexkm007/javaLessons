package ru.alexkm07.shop.model.documents.reference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
@EqualsAndHashCode(of = {"id"})
public class Manufacturer {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "manufacturers_sequence";
    private String name;
    @OneToOne
    private Country country;
}
