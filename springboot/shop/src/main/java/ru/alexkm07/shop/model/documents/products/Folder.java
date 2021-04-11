package ru.alexkm07.shop.model.documents.products;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
@EqualsAndHashCode(of = {"id"})
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "folders_sequence";
    private String name;
    @OneToOne
    private Folder parent;
}
