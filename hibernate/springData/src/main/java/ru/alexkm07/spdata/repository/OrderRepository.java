package ru.alexkm07.spdata.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.model.Order;

import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Set<Order> findOrderByCustomer(Customer customer);
}

