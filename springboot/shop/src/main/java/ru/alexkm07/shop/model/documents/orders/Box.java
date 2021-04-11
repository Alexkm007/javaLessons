package ru.alexkm07.shop.model.documents.orders;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Document(collection = "boxes")
public class Box {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "boxes_sequence";
    private LocalDateTime creationDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemBox> itemBoxes;
    @ManyToOne
    private User user;
    private Double amount;
}
