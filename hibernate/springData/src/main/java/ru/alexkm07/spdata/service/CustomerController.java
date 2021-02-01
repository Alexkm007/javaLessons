package ru.alexkm07.spdata.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.repository.CustomerRepository;
import java.util.Optional;


@Service
public class CustomerController {

   private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer CustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }
}
