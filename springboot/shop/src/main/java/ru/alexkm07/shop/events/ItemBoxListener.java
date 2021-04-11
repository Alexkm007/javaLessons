package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import ru.alexkm07.shop.model.documents.orders.ItemBox;
import ru.alexkm07.shop.service.SequenceService;

public class ItemBoxListener extends AbstractMongoEventListener<ItemBox> {
    private final SequenceService sequenceGenerator;

    public ItemBoxListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<ItemBox> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(ItemBox.SEQUENCE_NAME));
        }
    }
}
