package ru.alexkm07.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.bank.model.AccountBalance;


public interface AccountBalanceRepository extends JpaRepository<AccountBalance,Long> {
}
