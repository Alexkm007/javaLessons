package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.alexkm07.shop.model.documents.products.Folder;
import ru.alexkm07.shop.service.util.SequenceService;

@Component
public class FolderListener extends AbstractMongoEventListener<Folder> {

    public FolderListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    private final SequenceService sequenceGenerator;


        @Override
        public void onBeforeConvert (BeforeConvertEvent<Folder> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Folder.SEQUENCE_NAME));
        }
    }
}
