package ru.alexkm07.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.orders.Box;

@Data
@EqualsAndHashCode( of = {"id"})
public class BoxDto <ItemBox> extends AbstractDoc{
    public BoxDto(Box box) {
        super();
        super.setItems(box.getItemBoxes());
        super.setAmount(box.getAmount());
        super.setUser(box.getUser());
        super.setId(box.getId());
    }
}
