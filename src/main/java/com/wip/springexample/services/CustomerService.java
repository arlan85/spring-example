package com.wip.springexample.services;

import com.wip.springexample.Repositories.CustomerRepository;
import com.wip.springexample.dto.CustomerDTO;
import com.wip.springexample.dto.mapper.MapDTOToCustomer;
import com.wip.springexample.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MapDTOToCustomer mapper;

    public CustomerService(CustomerRepository customerRepository, MapDTOToCustomer mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = this.mapper.map(customerDTO);
        this.customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        this.customerRepository.deleteById(id);
    }
}
