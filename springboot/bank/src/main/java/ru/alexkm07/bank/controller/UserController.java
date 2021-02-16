package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.repository.UserRepository;
import ru.alexkm07.bank.service.UserService;

import java.util.List;

@Service
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserList(Model model){

        List<User> users = userService.findAll();
        model.addAttribute("users",users);

        return "userlist";
    }

    @GetMapping("edit")
    public String getUser(Model model, @RequestParam("id") Long id){
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return "useredit";
    }


}
