package ru.alexkm007.mustashe_l18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @RequestMapping()
    public String staticResource(Model model) {
        return "login1";
    }
}
