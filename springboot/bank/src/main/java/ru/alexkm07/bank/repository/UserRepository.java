package ru.alexkm07.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.bank.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
