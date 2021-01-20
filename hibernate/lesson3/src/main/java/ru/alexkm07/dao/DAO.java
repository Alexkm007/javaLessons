package ru.alexkm07.dao;

public interface DAO<Entity, Key> {
    Entity read(Key key);
}

