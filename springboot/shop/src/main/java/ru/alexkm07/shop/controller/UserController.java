package ru.alexkm07.shop.controller;

import org.springframework.web.bind.annotation.*;
import ru.alexkm07.shop.model.documents.users.User;
import ru.alexkm07.shop.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

}
