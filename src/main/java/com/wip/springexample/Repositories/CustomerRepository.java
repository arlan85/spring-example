package com.wip.springexample.Repositories;

import com.wip.springexample.dto.CustomerDTO;
import com.wip.springexample.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
