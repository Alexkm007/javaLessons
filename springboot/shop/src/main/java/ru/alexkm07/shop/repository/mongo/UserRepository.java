package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.users.User;

public interface UserRepository extends MongoRepository<User,Long> {
}