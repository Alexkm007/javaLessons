package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

import java.io.IOException;
import java.util.List;

public class Aggregator {
    public static void main(String[] args) throws IOException {

        Provider provider = new Provider(new HHStrategy());
        HtmlView view = new HtmlView();
        Model model = new Model(view,provider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();


    }
}
