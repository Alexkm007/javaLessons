package ru.alexkm07.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.rest.domain.Message;

public interface MessageRepo extends JpaRepository<Message,Long> {
}
