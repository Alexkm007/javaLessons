package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.orders.ItemOrder;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
