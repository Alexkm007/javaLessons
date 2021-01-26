package ru.alexkm07.spdata.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.repository.CustomerRepository;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    public Customer CustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }
}
