package ru.alexkm07.shop.service.orders;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.ItemDto;
import ru.alexkm07.shop.model.documents.orders.Order;
import ru.alexkm07.shop.repository.mongo.OrderRepository;

@Service
public class CategoryService extends AbstractService<ItemDto,Long, Order, OrderRepository>{

    public CategoryService(OrderRepository repo) {
        super(repo);
    }
}
