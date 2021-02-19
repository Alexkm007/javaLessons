package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.model.Role;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @GetMapping("edit/{id}")
    public String getUser(Model model, @PathVariable("id") Long id){
        User user = userService.getById(id);
        //Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        model = userService.getDateForView(user,model,id);
        return "useredit";
    }

    @PostMapping("edit/{id}")
    public String saveUserEdit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam Map<String,String> allRequestParams){
        if(bindingResult.hasErrors()){
            model = ControllerUtils.getErrors(bindingResult, model);
            model = userService.getDateForView(user,model,id);
            return "useredit";
        }
        Set<Role> roleSet = new HashSet<>();
        for(Role role: Role.values()){
           String value =  allRequestParams.get(role.name());
           if(value.equals("on")){
               roleSet.add(role);
           }
        }
        user.setRoles(roleSet);
        String active = allRequestParams.get("active");
        if(active.equals("on")){
            user.setActive(true);
        }
        user.setId(id);
        userService.updateUser(user);

        return "redirect:/user/edit/"+user.getId();
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/user";
    }

}
