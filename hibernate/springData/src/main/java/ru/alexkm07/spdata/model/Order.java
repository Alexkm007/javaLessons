package ru.alexkm07.spdata.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Table(name = "orders")
public class Order {

    public Order(Date date, Customer customer, double totalAmount, double totalQuantity, Set<OrderRow> orderRowList) {
        this.date = date;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.totalQuantity = totalQuantity;
        this.orderRowList = orderRowList;
    }

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
    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Customer customer;
    @Setter
    @Getter
    private double totalAmount;
    @Setter
    @Getter
    private double totalQuantity;
    @Setter
    @Getter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<OrderRow> orderRowList;

    public void addRow(OrderRow orderRow){
        orderRowList.add(orderRow);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer.getName() +
                ", totalAmount=" + totalAmount +
                ", totalQuantity=" + totalQuantity +
                ", orderRowList=" + orderRowList +
                '}';
    }
}
