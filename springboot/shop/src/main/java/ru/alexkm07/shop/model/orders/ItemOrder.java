package ru.alexkm07.shop.model.orders;

import lombok.Data;
import ru.alexkm07.shop.model.products.Product;
import ru.alexkm07.shop.model.reference.Unit;

import javax.persistence.*;

@Entity
@Data
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rb_seq")
    @SequenceGenerator(name = "rb_seq", sequenceName = "rb_seq")
    private Long id;
    @OneToOne
    private Product product;
    @OneToOne
    private Unit unit;
    private Double quantity;

}
