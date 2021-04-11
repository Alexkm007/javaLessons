package ru.alexkm07.shop.model.documents.orders;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.products.Product;
import ru.alexkm07.shop.model.documents.reference.Unit;

import javax.persistence.*;

@Document(collection = "itemsorders")
@Data
public class ItemOrder {
    @Id
    private Long id;
    @OneToOne
    private Product product;
    @Transient
    public static final String SEQUENCE_NAME = "itemorders_sequence";
    @OneToOne
    private Unit unit;
    private Double quantity;
    @ManyToOne
    private Order order;
}
