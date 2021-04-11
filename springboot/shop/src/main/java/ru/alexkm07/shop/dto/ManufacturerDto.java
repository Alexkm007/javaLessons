package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.alexkm07.shop.model.documents.reference.Country;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Data
@EqualsAndHashCode(of = {"id"})
public class ManufacturerDto extends AbstractDto{
    private Long id;
    private String name;
    private Country country;
}
