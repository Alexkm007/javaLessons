package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.alexkm07.shop.model.documents.products.Category;
import ru.alexkm07.shop.model.documents.users.User;
import ru.alexkm07.shop.service.SequenceService;

@Component
public class CategoryListener extends AbstractMongoEventListener<Category> {

    public CategoryListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    private final SequenceService sequenceGenerator;


        @Override
        public void onBeforeConvert (BeforeConvertEvent<Category> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Category.SEQUENCE_NAME));
        }
    }
}
