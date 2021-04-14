package ru.alexkm07.shop.service.util;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<T, S, V, U extends MongoRepository<V, S>> implements Service<T, S, V> {

    private final U repo;

    public AbstractService(U repo) {
        this.repo = repo;
    }

    @Override
    public List<T> getAll(Class<T> tclass) {
        List<V> listDoc = repo.findAll();
        List<T> listDocDto = new ArrayList<>();
        for (V docDb : listDoc) {
            T docDto = null;

            try {
                docDto = tclass.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(docDb, docDto, "id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listDocDto;
    }

    @Override
    public T get(S id, T docDto) {
        V docDb = repo.findById(id).get();
        BeanUtils.copyProperties(docDb, docDto);
        return docDto;
    }

    @Override
    public T save(T docDto, V doc) {
        BeanUtils.copyProperties(docDto, doc, "id");
        repo.save(doc);
        BeanUtils.copyProperties(doc, docDto);
        return docDto;
    }

    @Override
    public T update(T docDto, S id) {
        V doc = repo.findById(id).get();
        BeanUtils.copyProperties(docDto, doc, "id");
        repo.save(doc);
        return docDto;
    }

    @Override
    public void delete(S id) {
        repo.delete(repo.findById(id).get());
    }
}
