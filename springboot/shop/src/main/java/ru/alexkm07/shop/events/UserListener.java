package ru.alexkm07.shop.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.alexkm07.shop.model.documents.users.User;
import ru.alexkm07.shop.service.SequenceService;

@Component
public class UserListener extends AbstractMongoEventListener<User> {

    public UserListener(SequenceService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    private final SequenceService sequenceGenerator;


        @Override
        public void onBeforeConvert (BeforeConvertEvent<User> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        }
    }
}
