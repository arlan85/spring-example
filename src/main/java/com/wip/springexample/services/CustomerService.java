package com.wip.springexample.services;

import com.wip.springexample.Repositories.CustomerRepository;
import com.wip.springexample.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }
}
