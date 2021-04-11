package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.reference.Unit;

public interface UnitRepository extends MongoRepository<Unit,Long> {
}
