package ru.alexkm07.shop.model.documents.orders;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Document(collection = "orders")
@Data
public class Order {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";
    private LocalDateTime creationDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemOrder> items;
    @ManyToOne
    private User user;
    private Double amount;
}
