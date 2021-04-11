package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.alexkm07.shop.model.documents.reference.Manufacturer;
import ru.alexkm07.shop.service.SequenceService;

@Component
public class ManufacturerListener extends AbstractMongoEventListener<Manufacturer> {

    public ManufacturerListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    private final SequenceService sequenceGenerator;


        @Override
        public void onBeforeConvert (BeforeConvertEvent<Manufacturer> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Manufacturer.SEQUENCE_NAME));
        }
    }
}
