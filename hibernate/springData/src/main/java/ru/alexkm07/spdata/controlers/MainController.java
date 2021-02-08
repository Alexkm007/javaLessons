package ru.alexkm07.spdata.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class MainController {

    @GetMapping()
    public String index(Model model){
        List<String[]> headlines = new ArrayList<>();
        headlines.add(new String[]{"customer/customers","Customers"});
        headlines.add(new String[]{"product/products","Products"});
        headlines.add(new String[]{"order/orders","Orders"});
        model.addAttribute("headlines",headlines);
        return "/index";
    }
}
