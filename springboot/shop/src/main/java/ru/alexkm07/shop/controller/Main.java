package ru.alexkm07.shop.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Main {

    public String getIndex(Model model){
        return "index";
    }
}
