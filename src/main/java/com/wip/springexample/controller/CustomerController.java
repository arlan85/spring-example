package com.wip.springexample.controller;

import com.wip.springexample.dto.CustomerDTO;
import com.wip.springexample.entities.Customer;
import com.wip.springexample.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getCustomers(){
        return this.customerService.getAllCustomers();
    }

    @PostMapping()
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDTO customerDTO) {
        this.customerService.addCustomer(customerDTO);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
        this.customerService.deleteCustomer(id);
        return  ResponseEntity.ok().build();
    }
}
