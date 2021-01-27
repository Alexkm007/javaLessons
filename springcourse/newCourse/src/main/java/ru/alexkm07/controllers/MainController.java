package ru.alexkm07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexkm07.domain.Message;
import ru.alexkm07.domain.User;
import ru.alexkm07.repos.MessagesRepo;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MainController {

    private final MessagesRepo messagesRepo;

    public MainController(MessagesRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messagesRepo.findAll();
        if (messages == null){
            messages = new ArrayList<>();
        }
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
            @RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);
        messagesRepo.save(message);

        Iterable<Message> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String text, Map<String, Object> model) {
        Iterable<Message> messages = null;

        if(text != null && !text.isEmpty()){
            messages = messagesRepo.findByTag(text);
        } else{
            messages = messagesRepo.findAll();
        }

        model.put("messages", messages);
        return "main";
    }

}