package StructuralPatterns.Adapter;

import javax.xml.crypto.Data;

public class DataBaseClient {
    public static void main(String[] args) {

        DataBase dataBase = new AdapterAppToDataBase();

        dataBase.save();
        dataBase.select();
        dataBase.update();
        dataBase.update();

    }
}
