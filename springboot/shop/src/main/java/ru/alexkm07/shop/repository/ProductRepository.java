package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.products.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
