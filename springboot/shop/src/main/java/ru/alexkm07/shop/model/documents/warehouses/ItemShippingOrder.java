package ru.alexkm07.shop.model.documents.warehouses;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.products.Product;
import ru.alexkm07.shop.model.documents.reference.Unit;

import javax.persistence.*;

@Document
@Data
public class ItemShippingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Product product;
    @OneToOne
    private Unit unit;
    private Double quantity;

}
