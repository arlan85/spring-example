package com.wip.springexample.services;

import com.wip.springexample.Repositories.CustomerRepository;
import com.wip.springexample.dto.CustomerDTO;
import com.wip.springexample.dto.mapper.MapDTOToCustomer;
import com.wip.springexample.entities.Customer;
import com.wip.springexample.exceptions.CustomerExceptions;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MapDTOToCustomer mapper;

    public CustomerService(CustomerRepository customerRepository, MapDTOToCustomer mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = this.mapper.map(customerDTO);
        this.customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        Optional<Customer> optCustomer = this.customerRepository.findById(id);
        if (optCustomer.isEmpty()) {
            throw new CustomerExceptions("Customer not found on system", HttpStatus.NOT_FOUND);
        }
        this.customerRepository.deleteById(id);
    }

    @Transactional
    public Customer updateCustomer(Integer id, CustomerDTO customerDTO) {
        Optional<Customer> optCustomer = this.customerRepository.findById(id);
        if (optCustomer.isEmpty()) {
            throw new CustomerExceptions("Customer not found on system", HttpStatus.NOT_FOUND);
        }
        Customer customer = optCustomer.get();
        if(customerDTO.getAge() != 0) customer.setAge(customerDTO.getAge());
        if(!customerDTO.getName().equals("")) customer.setName(customerDTO.getName());
        if(!customerDTO.getEmail().equals("")) customer.setEmail(customerDTO.getEmail());

        return this.customerRepository.save(customer);
    }
}
