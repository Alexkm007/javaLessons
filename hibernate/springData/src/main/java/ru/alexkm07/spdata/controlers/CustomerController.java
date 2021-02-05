package ru.alexkm07.spdata.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cusomers")
public class CustomerController {

    @GetMapping()
    public String allCustomers(Model model){
        return "customersList";
    }


}
