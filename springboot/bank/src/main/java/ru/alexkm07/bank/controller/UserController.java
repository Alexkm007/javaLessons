package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.model.Role;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        Map<String,String> roles = new HashMap<>();
        for(Role role:Role.values()){
            if(user.getRoles().contains(role)){
                roles.put(role.name(),"checked");
            } else {
                roles.put(role.name(),"");
            }
        }
        model.addAttribute("user",user);
        model.addAttribute("roles",roles.entrySet());
        if(user.getActive()){
            model.addAttribute("active","checked");
        } else {
            model.addAttribute("active","");
        }

        return "useredit";
    }

    @PostMapping("edit/{id}")
    public String saveUserEdit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", " Error data");
            return "redirect:/user/edit?id="+user.getId();
        }
        return "redirect:redirect:/user/edit?id="+user.getId();
    }

}
