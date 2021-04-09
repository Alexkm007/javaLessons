package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.finance.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
