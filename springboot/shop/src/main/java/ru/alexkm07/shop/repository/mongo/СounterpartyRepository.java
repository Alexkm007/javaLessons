package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.warehouses.Counterparty;

public interface СounterpartyRepository extends MongoRepository<Counterparty,Long> {
}
