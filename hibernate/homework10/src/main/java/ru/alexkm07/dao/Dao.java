package ru.alexkm07.dao;

public interface Dao<Entity, Key> {
    public Entity read(Key id);
    public void create(Entity obj);
    public void update(Entity obj);
    public void delete(Entity obj);
}
