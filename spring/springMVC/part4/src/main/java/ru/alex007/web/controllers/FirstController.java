package ru.alex007.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "surname",required = false) String surname){
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodBye")
    public String goodByePage(){
        return "first/goodByePage";
    }

}
