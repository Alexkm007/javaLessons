package ru.alexkm07.shop.model.orders;

import lombok.Data;
import ru.alexkm07.shop.model.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ord_seq")
    @SequenceGenerator(name = "ord_seq", sequenceName = "ord_seq")
    private Long id;
    private LocalDateTime creationDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemBox> items;
    @ManyToOne
    private User user;
    private Double amount;
}
