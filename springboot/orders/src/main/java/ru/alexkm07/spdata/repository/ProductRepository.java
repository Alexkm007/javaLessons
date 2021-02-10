package ru.alexkm07.spdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.spdata.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
