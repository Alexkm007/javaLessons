package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.products.Product;

public interface ProductRepository extends MongoRepository<Product,Long> {
}
