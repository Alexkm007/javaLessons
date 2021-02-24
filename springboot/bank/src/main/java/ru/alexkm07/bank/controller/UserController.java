package ru.alexkm07.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.dto.UserDto;
import ru.alexkm07.bank.model.Role;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserList(@AuthenticationPrincipal User activeUser, Model model) {

        List<UserDto> users = userService.findAll();
        model.addAttribute("users", users);
        log.info(activeUser + " requested users data");
        return "userslist";
    }

    @GetMapping("edit/{id}")
    public String getUser(Model model, @PathVariable("id") Long id,@AuthenticationPrincipal User activeUser) {
        log.info(activeUser + " requested user data with id " + id);
        UserDto user = userService.getById(id);
        //Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        model = userService.getDateForView(user, model, id);
        return "user";
    }

    @PostMapping("edit/{id}")
    public String saveUserEdit(@Valid UserDto user, BindingResult bindingResult, @PathVariable("id") Long id, Model model,
                               @RequestParam Map<String, String> allRequestParams, @AuthenticationPrincipal User activeUser) {
        user = addRoleInSet(user, allRequestParams);
        if (bindingResult.hasErrors()) {
            model = ControllerUtils.getErrors(bindingResult, model);
            model = userService.getDateForView(user, model, id);
            return "user";
        }
        user.setId(id);
        userService.updateUser(user);
        log.info(activeUser + " update user data with id " + id);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,@AuthenticationPrincipal User activeUser) {
        userService.deleteUser(id);
        log.info(activeUser + " delete user data with id " + id);
        return "redirect:/users";
    }

    @GetMapping("add")
    public String addUser(Model model) {
        UserDto user = new UserDto();
        model = userService.getDateForView(user, model, 0L);
        return "user";
    }

    @PostMapping("add")
    public String saveNewUser(@Valid UserDto user, BindingResult bindingResult,Model model,@RequestParam Map<String,
            String> allRequestParams,@AuthenticationPrincipal User activeUser){
        user = addRoleInSet(user, allRequestParams);
        if (bindingResult.hasErrors()) {
            model = ControllerUtils.getErrors(bindingResult, model);
            model = userService.getDateForView(user, model, 0L);
            return "user";
        }
        userService.saveUser(user);
        log.info(activeUser + " add new user " + user);
        return "redirect:/users";
    }

    private UserDto addRoleInSet(@Valid UserDto user, @RequestParam Map<String, String> allRequestParams) {
        Set<Role> roleSet = new HashSet<>();
        for (Role role : Role.values()) {
            String value = allRequestParams.get(role.name());
            if(value==null){
                continue;
            }
            if (value.equals("on")) {
                roleSet.add(role);
            }
        }
        user.setRoles(roleSet);
        String active = allRequestParams.get("active");
        if (active.equals("on")) {
            user.setActive(true);
        }

        return user;
    }


}
