package ru.alexkm07.spdata.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

   private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public void update(Customer customer, Long id){
        Customer customerToUpdate = customerRepository.findById(id).get();
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setAddress(customer.getAddress());
        customerRepository.save(customerToUpdate);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
