package ru.alexkm07.spdata.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexkm07.spdata.model.Order;
import ru.alexkm07.spdata.model.OrderRow;
import ru.alexkm07.spdata.service.OrderRowService;
import ru.alexkm07.spdata.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/order")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService, OrderRowService orderRowService) {
        this.orderService = orderService;
    }

    @GetMapping("orders")
    public String allOrders(Model model){
        model.addAttribute("orders",orderService.getAll());
        return "orders";
    }

    @GetMapping("neworder")
    public String newOrder(Model model){
        model.addAttribute("customers",orderService.getCustomers());
        model.addAttribute("products",orderService.getProducts());
        return "neworder";
    }

    @PostMapping("neworder")
    public String saveOrder(@Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:neworder";
        }
        orderService.save(order);
        return "redirect:orders";
    }

    @GetMapping("editorder")
    public String editOrder(@RequestParam("id") Long id, Model model){
        Order order = orderService.getById(id);
        Set<OrderRow> orderRows = order.getOrderRowList();
        model.addAttribute("order",order);
        model.addAttribute("orderrows",orderRows);
        model.addAttribute("customers",orderService.getCustomers());
        model.addAttribute("products",orderService.getProducts());
        return "neworder";
    }

    @GetMapping("newrow")
    public String newRow(@RequestParam("id") Long id, Model model){
        model.addAttribute("products",orderService.getProducts());
        return "newrow";
    }

    @PostMapping("addrow")
    public String addRow(@Valid Order order, @RequestParam("id") Long id,Model model){
        orderService.updateOrder(order,id);
        return "redirect:newrow?id="+id;
    }

}
