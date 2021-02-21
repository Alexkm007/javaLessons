package ru.alexkm07.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alexkm07.bank.model.Role;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("registration")
    public  String GetRegistration(Model model)
    {
        model.addAttribute("logout","logout_page");
        return "registration_page";
    }

    @PostMapping("registration")
    public String adduser(@Valid User user, BindingResult bindingResult, Model model){
        User userFromDb = userService.findByName(user.getUsername());
        model.addAttribute("user",user);
        model.addAttribute("email",user.getEmail());
        if(userFromDb != null){
          model.addAttribute("message", "User exist!");
            return "registration_page";
        }
       if(bindingResult.hasErrors()){
           ControllerUtils.getErrors(bindingResult,model);
           return "registration_page";
       }
        userService.addUser(user);
       log.info(" registered new user " + user);
       return "redirect:login";
    }
}
