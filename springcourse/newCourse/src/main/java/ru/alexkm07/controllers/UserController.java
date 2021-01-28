package ru.alexkm07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexkm07.repos.UsersRepo;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UsersRepo userRepo;

    public UserController(UsersRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String userLisr(){
        return "userlist";
    }

}
