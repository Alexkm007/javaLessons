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

    @GetMapping("order")
    public String newOrder(Model model){
        model.addAttribute("customers",orderService.getCustomers());
        model.addAttribute("products",orderService.getProducts());
        return "order";
    }

    @PostMapping("order")
    public String saveOrder(@Valid Order order, BindingResult bindingResult, @RequestParam("id") Long id){
        if(bindingResult.hasErrors()){
            return "redirect:order";
        }
        id = orderService.save(order,id);
        return "redirect:editorder?id="+id;
    }

    @GetMapping("editorder")
    public String editOrder(@RequestParam("id") Long id, Model model){
        Order order = orderService.getById(id);
        Set<OrderRow> orderRows = orderService.getOrderRows(order);
        model.addAttribute("order",order);
        model.addAttribute("orderrows",orderRows);
        model.addAttribute("customers",orderService.getCustomers());
        model.addAttribute("products",orderService.getProducts());
        return "order";
    }

    @GetMapping("row")
    public String newRow(@RequestParam("id") Long id, Model model){
        model.addAttribute("products",orderService.getProducts());
        model.addAttribute("id",id);
        return "row";
    }

    @PostMapping("addrow")
    public String addRow(@Valid Order order, @RequestParam("id") Long id,Model model){
        orderService.updateOrder(order,id);
        return "redirect:row?id="+id;
    }

    @PostMapping("saverow")
    public String saveRow(@Valid OrderRow orderRow, BindingResult bindingResult, @RequestParam("order_id") Long id, @RequestParam("id") Long id_row, Model model){
        orderService.addRow(orderRow,id,id_row);
        return "redirect:editorder?id="+id;
    }

    @GetMapping("deleteorder")
    public String deleteOrder(@RequestParam("id") Long id, Model model){
        orderService.delete(orderService.getById(id));
        model.addAttribute("orders",orderService.getAll());
        return "orders";
    }

    @GetMapping("deleterow")
    public String deleteRow(@RequestParam("id") Long id, @RequestParam("order_id") Long order_id){
        orderService.deleteRow(id);
        return "redirect:editorder?id="+order_id;
    }

    @GetMapping("editrow")
    public String editRow(@RequestParam("id") Long id, @RequestParam("order_id") Long order_id,Model model){
        model.addAttribute("id",order_id);
        model.addAttribute("products",orderService.getProducts());
        OrderRow row = orderService.getRowById(id);
        model.addAttribute("row",row);
        return "row";
    }

}
