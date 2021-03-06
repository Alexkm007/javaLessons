package ru.alexkm07.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_rows")
public class OrderRow {

    public OrderRow(@NonNull Product product, @NonNull Order order, double price, double quantity, double amount) {
        this.product = product;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue
    private int id;
    @Getter
    @Setter
    @ManyToOne
    @NonNull
    @JoinColumn(name = "product_id")
    private Product product;
    @Getter
    @Setter
    @NonNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private double quantity;
    @Getter
    @Setter
    private double amount;

    @Override
    public String toString() {
        return "OrderRow{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order.getId() +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
