package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.finance.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
