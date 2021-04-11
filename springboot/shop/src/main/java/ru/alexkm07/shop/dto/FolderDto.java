package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = {"id"})
public class FolderDto extends AbstractDto{
    private Long id;
    private String name;
    private FolderDto parent;
}
