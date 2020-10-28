package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

import java.io.IOException;
import java.util.List;

public class Aggregator {
    public static void main(String[] args) throws IOException {

        Provider provider = new Provider(new HHStrategy());
        Provider moikrugProvider = new Provider(new MoikrugStrategy());
        HtmlView view = new HtmlView();
        Model model = new Model(view, provider, moikrugProvider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();


    }
}
