package ru.alexkm07.bank.repository;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Transaction;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findAllByFromAccountOrToAccount(Account accountFrom, Account accountTo);
}
