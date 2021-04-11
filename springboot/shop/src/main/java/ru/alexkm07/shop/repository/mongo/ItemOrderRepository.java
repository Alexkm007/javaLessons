package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.orders.ItemOrder;

public interface ItemOrderRepository extends MongoRepository<ItemOrder,Long> {
}
