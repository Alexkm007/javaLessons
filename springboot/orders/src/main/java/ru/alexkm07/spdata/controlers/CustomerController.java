package ru.alexkm07.spdata.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.service.CustomerService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public String allCustomers(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "customers";
    }

    @GetMapping("newcustomer")
    public String newCustomer(){
        return "newcustomer";
    }

    @PostMapping("newcustomer")
    public String addCustomer(@Valid Customer customer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/customer/newcustomer";
        }
        customerService.save(customer);
        return "redirect:/customer/customers";
    }

    @GetMapping("editcustomer")
    public String editCustomer(Model model, @RequestParam("id") Long id){
        Customer customer = customerService.findById(id);
        model.addAttribute("name_customer","\""+customer.getName()+"\"");
        model.addAttribute("address_customer","\""+ customer.getAddress()+"\"");
        model.addAttribute("id_customer",customer.getId());
        return "editcustomer";
    }

    @PostMapping("editcustomer")
    private String updateCustomer(@Valid Customer customer, BindingResult bindingResult, @RequestParam("id") Long id){
        if(bindingResult.hasErrors()) {
            return "redirect:editcustomer?id="+id;
        }
        customerService.update(customer,id);
        return "redirect:customers";
    }

    @GetMapping("deletecustomer")
    private String deleteCustomer(@RequestParam("id") Long id){
        customerService.delete(id);
        return "redirect:customers";
    }

}
