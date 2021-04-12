package ru.alexkm07.shop.service.util;

import java.util.List;

public interface Service<T,S,V> {
    List<T> getAll(Class<T> tclass);
    T get(S id,T docDto);
    T save(T docDto, V doc);
    T update(T docDto, S id);
    void delete(S id);

}
