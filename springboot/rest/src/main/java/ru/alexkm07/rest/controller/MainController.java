package ru.alexkm07.rest.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexkm07.rest.domain.User;
import ru.alexkm07.rest.repo.MessageRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final MessageRepo messageRepo;

    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public  String main(Model model, @AuthenticationPrincipal User user){
        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile",user);
        data.put("messages",messageRepo.findAll());
        model.addAttribute("frontendData", data);
        return "index";
    }

}
