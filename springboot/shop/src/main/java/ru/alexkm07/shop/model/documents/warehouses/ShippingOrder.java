package ru.alexkm07.shop.model.documents.warehouses;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Document
public class ShippingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
