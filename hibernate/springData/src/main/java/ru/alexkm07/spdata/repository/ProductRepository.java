package ru.alexkm07.spdata.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexkm07.spdata.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
