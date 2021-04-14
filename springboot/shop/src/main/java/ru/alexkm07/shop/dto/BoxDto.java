package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.documents.orders.Box;

@Data
@EqualsAndHashCode( of = {"id"})
public class BoxDto <ItemBox> extends AbstractDoc{
    public BoxDto() {
        super();
    }
}
