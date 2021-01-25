package ru.alexkm07.spdata.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexkm07.spdata.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>  {
}
