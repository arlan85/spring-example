package com.wip.springexample.dto.mapper;

import com.wip.springexample.dto.CustomerDTO;
import com.wip.springexample.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class MapDTOToCustomer implements IMapper<CustomerDTO, Customer> {
    @Override
    public Customer map(CustomerDTO in) {
        Customer customer;
        customer = new Customer(in.getName(), in.getEmail(), in.getAge());
        return customer;
    }
}
