package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.orders.Box;

public interface BoxRepository extends MongoRepository<Box,Long> {
}
