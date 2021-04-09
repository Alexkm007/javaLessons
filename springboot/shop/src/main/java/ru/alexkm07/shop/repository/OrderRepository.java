package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.orders.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
