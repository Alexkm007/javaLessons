package ru.alexkm07.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.domain.User;

public interface UsersRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
