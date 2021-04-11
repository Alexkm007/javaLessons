package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import ru.alexkm07.shop.model.documents.orders.ItemBox;
import ru.alexkm07.shop.model.documents.orders.ItemOrder;
import ru.alexkm07.shop.service.SequenceService;

public class ItemOrderListener extends AbstractMongoEventListener<ItemOrder> {
    private final SequenceService sequenceGenerator;

    public ItemOrderListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<ItemOrder> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(ItemOrder.SEQUENCE_NAME));
        }
    }
}
