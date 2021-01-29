package ru.alexkm07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alexkm07.domain.Role;
import ru.alexkm07.domain.User;
import ru.alexkm07.repos.UsersRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UsersRepo userRepo;

    public RegistrationController(UsersRepo usersRepo) {
        this.userRepo = usersRepo;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

}
