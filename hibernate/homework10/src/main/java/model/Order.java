package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Setter
    @Getter
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
    private List<OrderRow> orderRowList;
}
