package ru.alexkm07.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.rest.domain.User;

public interface UserDetailsRepo  extends JpaRepository<User,String> {
}
