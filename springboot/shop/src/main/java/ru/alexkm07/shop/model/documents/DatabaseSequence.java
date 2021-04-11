package ru.alexkm07.shop.model.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
}
