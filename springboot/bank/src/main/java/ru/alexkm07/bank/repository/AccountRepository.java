package ru.alexkm07.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.User;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByOwner(User user);
}
