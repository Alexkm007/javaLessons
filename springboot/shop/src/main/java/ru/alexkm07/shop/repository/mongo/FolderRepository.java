package ru.alexkm07.shop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alexkm07.shop.model.documents.products.Folder;

public interface FolderRepository extends MongoRepository<Folder,Long> {
}
