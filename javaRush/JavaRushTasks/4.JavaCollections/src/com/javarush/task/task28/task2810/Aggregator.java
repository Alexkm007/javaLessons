package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;

import java.util.List;

public class Aggregator {
    public static void main(String[] args) {

        Provider provider = new Provider(new Strategy() {
            @Override
            public List getVacancies(String searchString) {
                return null;
            }
        });
        Controller controller = new Controller(provider);
        controller.scan();

    }
}
