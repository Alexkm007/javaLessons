package ru.alexkm07.spdata.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexkm07.spdata.model.OrderRow;

public interface OrderRowRepository extends CrudRepository<OrderRow,Long> {
}
