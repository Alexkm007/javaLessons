package ru.alexkm07.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.bank.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
