package ru.alexkm07.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.alexkm07.domain.Message;

import java.util.List;

public interface MessagesRepo extends JpaRepository<Message,Long> {
    List<Message> findByTag(String text);
}
