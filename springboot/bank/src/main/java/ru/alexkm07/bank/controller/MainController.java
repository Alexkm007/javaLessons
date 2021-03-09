package ru.alexkm07.bank.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alexkm07.bank.model.User;

@Controller
public class MainController {


    @GetMapping()
    public String getIndex(Model model) {
        String greeting = "Welcome to Burundutu national bank!";
         model.addAttribute("greeting", greeting);
        return "index";
    }

    @GetMapping("main")
    public String getMain(Model model, @AuthenticationPrincipal User activeUser) {
        String greeting = "Welcome to Burundutu national bank!";
        model.addAttribute("greeting", greeting);
        if(activeUser.isAdmin()) model.addAttribute("isadmin","true");
        return "main";
    }

    @GetMapping("login")
    private String login(Model model) {
        model.addAttribute("logout", "logout_page");
        return "login";
    }

}
