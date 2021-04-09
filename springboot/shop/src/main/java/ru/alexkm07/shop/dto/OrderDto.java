package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.orders.Order;

@Data
@EqualsAndHashCode( of = {"id"})
public class OrderDto<ItemOrder> extends AbstractDoc{
    public OrderDto(Order order) {
        super();
        super.setItems(order.getItems());
        super.setAmount(order.getAmount());
        super.setUser(order.getUser());
        super.setId(order.getId());
    }
}
