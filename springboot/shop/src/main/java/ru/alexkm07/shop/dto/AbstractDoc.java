package ru.alexkm07.shop.dto;

import lombok.Data;
import ru.alexkm07.shop.model.documents.users.User;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public abstract class AbstractDoc <T> extends AbstractDto {

    private LocalDateTime creationDate;
    private Set<T> items;
    private User user;
    private Double amount;

}
