package ru.alexkm07.spdata.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq")
    private Long id;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private double totalAmount;
    private double totalQuantity;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<OrderRow> orderRowList;

    public Order(Date date, Customer customer, double totalAmount, double totalQuantity, Set<OrderRow> orderRowList) {

        this.date = date;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.totalQuantity = totalQuantity;
        this.orderRowList = orderRowList;
    }

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
