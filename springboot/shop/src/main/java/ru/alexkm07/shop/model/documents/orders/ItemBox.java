package ru.alexkm07.shop.model.documents.orders;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.products.Product;
import ru.alexkm07.shop.model.documents.reference.Unit;

import javax.persistence.*;

@Data
@Document(collection = "itemsboxes")
public class ItemBox {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "itemboxes_sequence";
    @OneToOne
    private Product product;
    @OneToOne
    private Unit unit;
    private Double quantity;
    @ManyToOne
    private Box box;
}
