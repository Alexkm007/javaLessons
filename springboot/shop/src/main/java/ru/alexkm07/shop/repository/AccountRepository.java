package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.finance.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
