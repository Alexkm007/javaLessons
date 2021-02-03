package ru.alexkm07.spdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.alexkm07.spdata.model.OrderRow;

public interface OrderRowRepository extends JpaRepository<OrderRow,Long> {
}
