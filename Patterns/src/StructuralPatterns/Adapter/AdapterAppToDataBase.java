package StructuralPatterns.Adapter;

public class AdapterAppToDataBase extends JavaApp implements DataBase{

    @Override
    public void save() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        readObject();
    }

    @Override
    public void delete() {
        deleteObject();
    }
}
