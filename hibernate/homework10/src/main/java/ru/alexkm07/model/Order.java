package ru.alexkm07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Setter
    @Getter
    @GeneratedValue
    private int id;
    @Setter
    @Getter
    private Date date;
    @Setter
    @Getter
    private Customer customer;
    @Setter
    @Getter
    private double totalAmount;
    @Setter
    @Getter
    private double totalQuantity;
    @Setter
    @Getter
    private Set<OrderRow> orderRowList;
}
