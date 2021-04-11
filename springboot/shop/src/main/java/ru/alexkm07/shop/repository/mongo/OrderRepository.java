package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.orders.Order;

public interface OrderRepository extends MongoRepository<Order,Long> {
}
