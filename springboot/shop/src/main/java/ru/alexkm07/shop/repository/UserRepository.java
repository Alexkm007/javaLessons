package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.users.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
