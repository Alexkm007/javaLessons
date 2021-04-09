package ru.alexkm07.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexkm07.shop.model.users.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public List<User> getUsers(){

        List<User> list = new ArrayList<>();
        return list;

    }
}
