package ru.alexkm07.spdata.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_rows")
public class OrderRow {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderrow_seq")
    @SequenceGenerator(name = "orderrow_seq", sequenceName = "orderrow_seq")
    private Long id;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "product_id")
    private Product product;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Double price;
    private Double quantity;
    private Double amount;

    public OrderRow(@NonNull Product product, @NonNull Order order, Double price, Double quantity, Double amount) {
        this.product = product;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderRow{" +
                "id=" + id +
                ", product=" + product.getName() +
                ", order=" + order.getId() +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
