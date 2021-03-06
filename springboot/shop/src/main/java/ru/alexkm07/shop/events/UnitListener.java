package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.alexkm07.shop.model.documents.orders.Order;
import ru.alexkm07.shop.service.util.SequenceService;

@Component
public class UnitListener extends AbstractMongoEventListener<Order> {
    private final SequenceService sequenceGenerator;

    public UnitListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Order> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
        }
    }
}
