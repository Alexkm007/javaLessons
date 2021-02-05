package ru.alexkm07.spdata.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    public String allOrders(){
        return "orderslist";
    }
}
