package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.repository.UserRepository;

import java.util.List;

@Service
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String getUserList(Model model){

        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);

        return "userlist";
    }



}
