package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping()
    public String getIndex(Model model){
        String welcome = "Welcome to Burundutu national bank!";
        model.addAttribute("welcome",welcome);

        return "index";
    }

    @GetMapping("main")
    public String getMain(Model model){
        String welcome = "Welcome to Burundutu national bank!";
        model.addAttribute("welcome",welcome);
        return "main_page";
    }
    @GetMapping("login")
    private String login(Model model){
        model.addAttribute("logout","logout_page");
        return "login_page";
    }


}
