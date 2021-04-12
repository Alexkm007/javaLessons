package ru.alexkm07.shop.service.util;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import ru.alexkm07.shop.model.documents.DatabaseSequence;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceService {


    private final MongoOperations mongoOperations;

    public SequenceService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? Long.valueOf(counter.getSeq()) : 1;
    }
}
